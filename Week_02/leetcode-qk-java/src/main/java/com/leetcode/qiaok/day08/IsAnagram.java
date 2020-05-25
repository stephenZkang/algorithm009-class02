package com.leetcode.qiaok.day08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 难度：简单
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * @since 2020-05-25
 * @author qiaok
 */
public class IsAnagram {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        IsAnagram test = new IsAnagram();
        String s = "anagram";
        String t = "nagaram";
        long start = System.currentTimeMillis();
        boolean res = test.isAnagram2(s,t);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 四大步骤：
     *  1、确定题的含义和条件
     *  2、所有解法，比较选优
     *  3、实现
     *  4、Test Case
     *
     *  异位词含义不明白，指：出现的字母次数相同，位置不同
     *  排序+比较
     *
     * 时间复杂度： O(nlogn)
     * 空间复杂度： O(1)
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars,tChars);
    }

    /**
     * 四大步骤：
     *  1、确定题的含义和条件
     *  2、所有解法，比较选优
     *  3、实现
     *  4、Test Case
     *
     *  异位词含义不明白，指：出现的字母次数相同，位置不同
     *  哈希表
     *
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram1(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        int[] counters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counters[s.charAt(i) - 'a']++;
            counters[t.charAt(i) - 'a']--;
        }

        for (int count: counters) {
            if(count!=0){
                return  false;
            }
        }

        return true;
    }


    /**
     * 四大步骤：
     *  1、确定题的含义和条件
     *  2、所有解法，比较选优
     *  3、实现
     *  4、Test Case
     *
     *  异位词含义不明白，指：出现的字母次数相同，位置不同
     *  哈希表
     *
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * @param s
     * @param t
     * @return
     */
    private boolean isAnagram2(String s, String t) {
        if (s==null && t==null) return true;
        else if (s==null || t==null) return false;
        else if (s.length() != t.length()) return false;

        final Map<Integer, Integer> dict = new HashMap<>();
        s.codePoints().forEach(code -> dict.put(code, dict.getOrDefault(code, 0) + 1));
        t.codePoints().forEach(code -> dict.put(code, dict.getOrDefault(code, 0) - 1));

        for(int count : dict.values()) {
            if (count<0) return false;
        }

        return true;
    }
}
