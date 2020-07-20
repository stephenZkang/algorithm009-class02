package com.leetcode.qiaok.day70;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 *
 * 示例：
 *
 * 输入：
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * 输出：3
 * 解释：
 * 长度最长的公共子数组是 [3, 2, 1] 。
 *
 *
 * 提示：
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * @since 2020-07-12
 * @author qiaok
 */
public class FindLength {
    public static void main(String[] args){
        FindLength test = new FindLength();
        int[] A = { 1,2,3,2,1 };
        int[] B = { 3,2,1,4,7 };
        long start = System.currentTimeMillis();
        int res = test.findLength(A,B);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 动态规划
     * 时间复杂度：
     * 空间复杂度：
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length; int m = B .length;
        int[][] dp = new int[n+1][m+1];

        int ans = 0;
        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                dp[i][j] = A[i] == B[j] ?dp[i+1][j+1] +1:0;
                ans = Math.max(dp[i][j],ans);
            }
        }
        return ans;
    }
}
