package com.leetcode.qiaok.day28;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。
 * 多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * @since 2020-06-14
 * @author qiaok
 *
 */
public class MajorityElement {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        MajorityElement test = new MajorityElement();
        int[] nums = { 3,2,3 };
        long start = System.currentTimeMillis();
        int res = test.majorityElement(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 第一个元素跟后面相比
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @return
     */
    private int majorityElement(int[] nums) {
        int cand_num = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (cand_num == nums[i])
                ++count;
            else if (--count == 0) {
                cand_num = nums[i];
                count = 1;
            }
        }
        return cand_num;
    }
}
