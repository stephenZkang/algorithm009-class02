package com.leetcode.qiaok.day23;

import java.util.ArrayList;
import java.util.List;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
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
 * @since 2020-06-09
 * @author qiaok
 */
public class ClimbStairs {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        ClimbStairs test = new ClimbStairs();
        int n = 3;
        long start = System.currentTimeMillis();
        int res = test.climbStairs(n);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res=" + res);
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        return _climb_stairs(0,n,memo);
    }

    private int _climb_stairs(int i, int n, int[] memo) {
        if(i>n){
            return 0;
        }
        if(i == n){
            return 1;
        }

        if(memo[i]>0){
            return memo[i];
        }

        memo[i] = _climb_stairs(i+1,n,memo) + _climb_stairs(i+2,n,memo);
        return memo[i];
    }
}
