package com.leetcode.qiaok.day05;

/**
 * 11. 盛最多水的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 *
 * @since 2020-05-24
 * @author qiaok
 */
public class MaxArea {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        MaxArea test = new MaxArea();
        int[] nums = { 1,8,6,2,5,4,8,3,7 };
        long start = System.currentTimeMillis();
        int res = test.maxArea(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res=" + res);
    }

    /**
     * 滑动窗口
     * 时间复杂度： O(n)
     * 空间复杂度： O(1)
     * @param height
     * @return
     */
    private int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;

    }
}
