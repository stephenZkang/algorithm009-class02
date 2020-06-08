package com.leetcode.qiaok.day22;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * @since 2020-06-08
 * @author qiaok
 */
public class Permute {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        Permute test = new Permute();
        int[] nums = {1,2,3};
        long start = System.currentTimeMillis();
        List<List<Integer>> res = test.permute(nums);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res=" + res.toString());
    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * @param nums
     * @return
     */
    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        ArrayList<Integer> out = new ArrayList<Integer>();
        for (int num: nums) {
            out.add(num);
        }

        int n = nums.length;
        backtrack(n,out,res,0);
        return res;
    }

    /**
     *
     * @param n
     * @param output
     * @param res
     * @param first
     */
    private void backtrack(int n, ArrayList<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n)
            res.add(new ArrayList<Integer>(output));
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }
}
