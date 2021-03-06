package com.leetcode.qiaok.day70;

import java.util.Arrays;

/**
 * 213. 打家劫舍 II
 *  你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，
 *  这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，
 *  如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 *  给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 *  示例 1:
 *
 *  输入: [2,3,2]
 *  输出: 3
 *  解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 *  示例 2:
 *
 *  输入: [1,2,3,1]
 *  输出: 4
 *  解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *       偷窃到的最高金额 = 1 + 3 = 4 。
 *
 *   https://leetcode-cn.com/problems/house-robber-ii/description/
 *
 *  @since 2020-06-24
 *  @author qiaok
 */
public class Rob {

    public static void main(String[] args){
        Rob test = new Rob();
        int[] nums = {1,2,3,1};
        long start = System.currentTimeMillis();
        int res = test.rob(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);

    }

    /**
     * 时间复杂度：
     *      空间复杂度：
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for(int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

}
