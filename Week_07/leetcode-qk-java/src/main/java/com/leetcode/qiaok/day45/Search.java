package com.leetcode.qiaok.day45;

/**
 * 33. 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 *
 * @since 2020-06-27
 * @author qiaok
 */
public class Search {


    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        Search test = new Search();
        int[] nums = { 4,5,6,7,0,1,2 };
        int target = 0;
        long start = System.currentTimeMillis();
        int res = test.search(nums,target);
        System.out.println("耗时"+(System.currentTimeMillis() -start)+"毫秒");
        System.out.println("res="+res);

    }

    /**
     *
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @param target
     * @return
     */
    private int search(int[] nums, int target) {
        int lower = 0; int high = nums.length-1;int mid =0;
        while (lower<=high){
            mid = lower+ (high-lower)/2;
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid]>=nums[lower]){
                if(target>=nums[lower]&& target<nums[mid]){
                    high = mid -1;
                }else{
                    lower = mid + 1;
                }
            }else{
                if(target> nums[mid]&& target<=nums[high]){
                    lower=mid+1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }
}
