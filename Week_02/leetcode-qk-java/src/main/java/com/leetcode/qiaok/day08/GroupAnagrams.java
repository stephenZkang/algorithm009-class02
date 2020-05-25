package com.leetcode.qiaok.day08;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *  难度：中等
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 * @since 2020-05-25
 * @author qiaok
 */
public class GroupAnagrams {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        GroupAnagrams test = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        long start = System.currentTimeMillis();
        List<List<String>> res = test.groupAnagrams(strs);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res.toString());
    }

    /**
     * 排序数组分类
     * 时间复杂度：
     * 空间复杂度：
     * @param strs
     * @return
     */
    private List<List<String>> groupAnagrams(String[] strs) {
        if(strs==null||strs.length==0){
            return  new ArrayList<>();
        }
        Map<String,List> ans = new HashMap<>();
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!ans.containsKey(key)){
                ans.put(key,new ArrayList());
            }
            ans.get(key).add(s);

        }
        return new ArrayList(ans.values());
    }


    /**
     * 排序数组分类
     * 时间复杂度：
     * 空间复杂度：
     * @param strs
     * @return
     */
    private List<List<String>> groupAnagrams1(String[] strs) {
        // 考察了哈希函数的基本知识，只要 26 个即可
        // （小写字母ACSII 码 - 97 ）以后和质数的对应规则，这个数组的元素顺序无所谓
        // key 是下标，value 就是数值
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67, 71,
                73, 79, 83, 89, 97, 101};

        // key 是字符串自定义规则下的哈希值
        Map<Integer, List<String>> hashMap = new HashMap<>();
        for (String s : strs) {
            int hashValue = 1;

            char[] charArray = s.toCharArray();
            for (char c : charArray) {
                hashValue *= primes[c - 'a'];
            }

            // 把单词添加到哈希值相同的分组
            if (hashMap.containsKey(hashValue)) {
                List<String> curList = hashMap.get(hashValue);
                curList.add(s);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(s);

                hashMap.put(hashValue, newList);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
}
