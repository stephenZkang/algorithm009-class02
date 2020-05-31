package com.leetcode.qiaok.day14;

/**
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * @since 2020-06-01
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
        test.moveZeros(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     */
    private void moveZeros(int[] nums) {
        if(nums==null) {
            return;
        }
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
    }
}
