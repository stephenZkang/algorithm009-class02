package com.leetcode.qiaok.day48;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * https://leetcode-cn.com/problems/3sum/
 *
 * @since 2020-07-04
 * @author qiaok
 */
public class ThreeSum {

    public  static void  main(String[] args){
        ThreeSum test = new ThreeSum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        long start = System.nanoTime();
        List<List<Integer>>  res = test.threeSum(nums);
        System.out.println("耗时"+(System.nanoTime() -start)+"毫秒");
        System.out.println("res"+res);
    }

    /**
     * 排序 + 双指针
     * 时间复杂度:
     * 空间复杂度：
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }

            int third = n - 1;
            int target = -nums[i];
            for (int second = i + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > i + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[i]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }

        }
        return ans;
    }
}
