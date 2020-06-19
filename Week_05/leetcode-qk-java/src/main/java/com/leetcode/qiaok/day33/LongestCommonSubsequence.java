package com.leetcode.qiaok.day33;

/**
 *
 * 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 *
 * 提示:
 *
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 *
 * @since 2020-06-19
 * @author qiaok
 */
public class LongestCommonSubsequence {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        LongestCommonSubsequence test = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        long start = System.currentTimeMillis();
        int res = test.longestCommonSubsequence(text1,text2);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res=" + res);
    }

    /**
     *
     * 时间复杂度：
     * 空间复杂度：
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0) return 0;
        char[] chas1 = text1.toCharArray();
        char[] chas2 = text2.toCharArray();
        int m = chas1.length, n = chas2.length;
        int[][] dp = new int[m][n];
        dp[0][0] = chas1[0] == chas2[0] ? 1 : 0;
        for (int i = 1; i < m; i++) dp[i][0] = chas1[i] == chas2[0] ? 1 : dp[i - 1][0];
        for (int j = 1; j < n; j++) dp[0][j] = chas1[0] == chas2[j] ? 1 : dp[0][j - 1];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (chas1[i] == chas2[j]) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[m - 1][n - 1];
    }
}
