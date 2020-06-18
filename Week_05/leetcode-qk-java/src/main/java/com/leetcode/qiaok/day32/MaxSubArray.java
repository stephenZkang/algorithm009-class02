package com.leetcode.qiaok.day32;


/**
 * 53. 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * https://leetcode-cn.com/problems/maximum-subarray/
 * @since 2020-06-18
 * @author qiaok
 */
public class MaxSubArray {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        MaxSubArray test = new MaxSubArray();
        int[] nums = { -2,1,-3,4,-1,2,1,-5,4 };
        long start = System.currentTimeMillis();
        int res  = test.maxSubArray(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+ res);
    }

    /**
     * 动态规划
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]= Math.max(dp[i-1]+nums[i],nums[i]);
            if(max < dp[i]){
                max = dp[i];
            }
        }
        return max;
    }
}
