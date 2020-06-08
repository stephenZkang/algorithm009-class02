package com.leetcode.qiaok.day19;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * @since 2020-06-08
 * @author qiaok
 */
public class ClimbStairs {

    public static void main(String[] args){
        ClimbStairs test = new ClimbStairs();
        int n = 3;
        long start = System.currentTimeMillis();
        int res = test.climbStairs1(3);
        System.out.println("res="+res);
    }

    /**
     * 记忆化递归
     * 1 = 1
     * 2 = 1,1 或2
     * 3 = 1 ,2 或者2,1
     * f(n) = f(n-1)+f(n-2)
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return  climb_stairs(0,n,memo);
    }

    private int climb_stairs(int i, int n, int[] memo) {
        if(i>n){
            return 0;
        }

        if(i ==n){
            return 1;
        }

        if(memo[i] > 0){
            return memo[i];
        }
        memo[i] = climb_stairs(i+1,n,memo) +climb_stairs(i+2,n,memo);
        return memo[i];
    }

    /**
     * 动态规划
     * 1 = 1
     * 2 = 1,1 或2
     * 3 = 1 ,2 或者2,1
     * f(n) = f(n-1)+f(n-2)
     * 时间复杂度:O(n)
     * 空间复杂度:O(n)
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
