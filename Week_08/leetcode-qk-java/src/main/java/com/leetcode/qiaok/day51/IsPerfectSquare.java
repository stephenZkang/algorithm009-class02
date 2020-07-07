package com.leetcode.qiaok.day51;


/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
 *
 * 说明：不要使用任何内置的库函数，如  sqrt。
 *
 * 示例 1：
 *
 * 输入：16
 * 输出：True
 * 示例 2：
 *
 * 输入：14
 * 输出：False
 *
 * @since 2020-07-07
 * @author qiaok
 */
public class IsPerfectSquare {

    public static void main(String[] args){
        IsPerfectSquare test = new IsPerfectSquare();
        int num = 16;
        long start = System.nanoTime();
        boolean res  = test.isPerfectSquare(num);
        System.out.println("耗时"+(System.nanoTime() - start)+"毫秒");
        System.out.println("res="+res);

    }

    /**
     * 二分查找
     *  超出时间限制
     *  start 不能使用int，必须使用long，否则会报错
     * 时间复杂度：
     * 空间复杂度：
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long start =0; long end = num;
        while (start<=end){
            long mid = start + (end-start)/2;
            if(num == mid*mid){
                return true;
            }
            if(num>mid*mid){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }

    /**
     * 二分查找
     * 时间复杂度：
     * 空间复杂度：
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 2) {
            return true;
        }

        long left = 2, right = num / 2, x, guessSquared;
        while (left <= right) {
            x = left + (right - left) / 2;
            guessSquared = x * x;
            if (guessSquared == num) {
                return true;
            }
            if (guessSquared > num) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }
        return false;
    }
}
