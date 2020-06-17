package com.leetcode.qiaok.day30;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @since 2020-06-17
 * @author qiaok
 */
public class TwoNum {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        TwoNum test = new TwoNum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        long start = System.currentTimeMillis();
        int[] res = test.twoNum(nums,target);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+ Arrays.toString(res));
    }

    /**
     * 哈希
     * @param nums
     * @param target
     * @return
     */
    public int[] twoNum(int[] nums, int target) {
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            m.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if(m.containsKey(n)&&m.get(n)!=i){
                return new int[]{m.get(n),i};
            }
        }
        throw new RuntimeException("");
    }

    /**
     * 优化哈希
     * @param nums
     * @param target
     * @return
     */
    public int[] twoNum1(int[] nums, int target) {
        HashMap<Integer,Integer> m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if(m.containsKey(n)&&m.get(n)!=i){
                return new int[]{m.get(n),i};
            }
            m.put(nums[i],i);
        }
        throw new RuntimeException("");
    }


}
