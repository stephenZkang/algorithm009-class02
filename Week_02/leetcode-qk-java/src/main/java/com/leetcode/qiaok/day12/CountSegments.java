package com.leetcode.qiaok.day12;

/**
 * 434. 字符串中的单词数
 * 统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。
 *
 * 请注意，你可以假定字符串里不包括任何不可打印的字符。
 * 示例:
 *
 * 输入: "Hello, my name is John"
 * 输出: 5
 * 解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
 *
 * @since 2020-05-29
 * @author qiaok
 */
public class CountSegments {

    /**
     * 测试
     * @param args
     */
    public static  void main(String[] args){
        CountSegments test = new CountSegments();
        String s = "Hello, my name is John";
        long start = System.currentTimeMillis();
        int res = test.countSegments1(s);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 使用语言内置函数 【通过】
     * 时间复杂度：
     * 空间复杂度：
     * @param s
     * @return
     */
    private int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;

    }


    /**
     * 原地法 【通过】
     * 时间复杂度：O(n)
     * 空间复杂度：
     * @param s
     * @return
     */
    private int countSegments1(String s) {
        int segmentCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                segmentCount++;
            }
        }

        return segmentCount;
    }
}
