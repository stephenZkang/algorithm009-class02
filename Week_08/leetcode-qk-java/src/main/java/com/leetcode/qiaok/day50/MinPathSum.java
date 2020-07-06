package com.leetcode.qiaok.day50;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 *
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @since 2020-06-22
 * @author qiaok
 */
public class MinPathSum {

    public static void main(String[] args){
        MinPathSum test = new MinPathSum();
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        long start = System.currentTimeMillis();
        int res = test.minPathSum1(grid);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 一维动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >=0 ; i--) {
            for (int j = grid[0].length-1; j >=0 ; j--) {
                if(i == grid.length -1 && j != grid[0].length-1){
                    dp[j] = grid[i][j] + dp[j+1];
                }else if(j == grid[0].length - 1&& i != grid.length -1){
                    dp[j] = grid[i][j] + dp[j];
                }else if(j != grid[0].length - 1 && i != grid.length - 1){
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                }else{
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    /**
     * 一维动态规划
     * 时间复杂度：O(mn)
     * 空间复杂度：O(n)
     * 执行用时： 2 ms , 在所有 Java 提交中击败了 98.10% 的用户
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[0][i] += grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                grid[i][j] += Math.min(grid[i][j - 1],grid[i - 1][j]);
            }
        }
        return grid[m - 1][n - 1];
    }
}
