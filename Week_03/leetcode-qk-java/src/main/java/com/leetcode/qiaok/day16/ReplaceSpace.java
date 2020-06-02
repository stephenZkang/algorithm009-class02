package com.leetcode.qiaok.day16;

/**
 * 面试题05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * 限制：
 * 0 <= s 的长度 <= 10000
 *
 * @since 2020-06-02
 * @author qiaok
 */
public class ReplaceSpace {
    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        ReplaceSpace test = new ReplaceSpace();
        String s = "We are happy.";
        long start = System.currentTimeMillis();
        String res = test.replaceSpace(s);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * @param s
     * @return
     */
    private String replaceSpace(String s) {
        if(s==null) return null;
        int length = s.length();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            if(s.charAt(i) == ' '){
                buffer.append("%20");
            }else{
                buffer.append(s.charAt(i));
            }
        }
        return buffer.toString();
    }


}
