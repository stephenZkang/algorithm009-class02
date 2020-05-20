package com.leetcode.qiaok.day03;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  1. 两数之和
 *  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 *  你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  示例:
 *
 *  给定 nums = [2, 7, 11, 15], target = 9
 *
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 * @since 2020-05-20
 * @author qiaok
 */
public class TwoSum {

    public static void main(String[] args){
        int[] nums = { 3,2,4 };
//        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        TwoSum test = new TwoSum();
        long start = System.currentTimeMillis();
        int[] res = test.twoSum1(nums,target);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+ Arrays.toString(res));
    }

    /**
     * 两次循环 hashmap
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            m.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if(m.containsKey(n)&&m.get(n)!=i){
                return new int[]{i,m.get(n)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 一次循环 hashmap
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum1(int[] nums, int target) {
        Map<Integer,Integer> m = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if(m.containsKey(n)&&m.get(n)!=i){
                return new int[]{i,m.get(n)};
            }
            m.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
