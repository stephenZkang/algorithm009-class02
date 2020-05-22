package com.leetcode.qiaok.day05;

import java.util.Arrays;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @since 2020-05-22
 * @author qiaok
 */
public class MoveZeros {

    /**
     * 测试
     * @param args
     */
    public static  void main(String[] args){
        MoveZeros test = new MoveZeros();
        int[] nums = { 0,1,0,3,12 };
        long start = System.currentTimeMillis();
        int[] res = test.moveZeros1(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+ Arrays.toString(res));
    }

    /**
     * 思路一：使用新数组
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @return
     */
    private int[] moveZeros(int[] nums) {
        int len = nums.length;
        int[] nms = new int[len];
        int last= 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != 0 ){
                nms[last] = nums[i];
                last++;
            }
        }
        for (int i = last; i < len; i++) {
            nms[i] = 0;
        }
        return nms;
    }

    /**
     * 思路二：原数组上修改
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @return
     */
    private int[] moveZeros1(int[] nums) {
        int len = nums.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            if(nums[i] != 0 ){
                int temp = nums[j];
                nums[j]=nums[i];
                nums[i] = temp;
                j++;
            }
        }
        return nums;
    }

}
