package com.leetcode.qiaok.day08;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 *
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 *
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，
 * 并且你不能一次加载所有的元素到内存中，你该怎么办？
 *
 * 1、确认题的含义
 * 2、思考所有解法，找出最优解
 * 3、实现
 * 4、Test Case
 *
 *
 * @since 2020-05-25
 * @author qiaok
 */
public class Intersect {

    /**
     * 测试
     */
    public static  void main(String[] args){
        Intersect test = new Intersect();
        int[] nums1 = { 4,9,5 };
        int[] nums2 = { 9,4,9,8,4 };
        long start = System.currentTimeMillis();
        int[] res = test.intersect(nums1,nums2);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+ Arrays.toString(res));

    }

    /**
     *  暴力解题
     * 时间复杂度： O(n*m)
     * 空间复杂度： O(min(n,m))
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < nums1.length; j++) {
            for (int k = j; k < nums2.length; k++) {
                if(nums1[j] == nums2[k]){
                    res.add(nums1[j]);
                    break;
                }
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }


    /**
     * 排序后比较,有点双指针的味道
     * 时间复杂度： O(nlogn+mlogm)
     * 空间复杂度： O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i =0;int j = 0;int k=0;
        while(i < nums1.length && j< nums2.length){
            if(nums1[i] < nums2[j]){
                ++i;
            }else if(nums1[i] > nums2[j]){
                ++j;
            }else{
                nums1[k++] = nums1[i++];
                ++j;
            }

        }
        return Arrays.copyOfRange(nums1,0,k);
    }




}
