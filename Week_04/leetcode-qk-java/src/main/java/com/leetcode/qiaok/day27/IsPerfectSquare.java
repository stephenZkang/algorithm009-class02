package com.leetcode.qiaok.day27;

/**
 * 367. 有效的完全平方数
 * 给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，
 * 则返回 True，否则返回 False。
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
 * @since 2020-06-13
 * @author qiaok
 */
public class IsPerfectSquare {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        IsPerfectSquare test = new IsPerfectSquare();
        int num =16;
        long start = System.currentTimeMillis();
        boolean res = test.isPerfectSquare(num);
        System.out.println("耗时"+(System.currentTimeMillis() -start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 二分查找
     * 时间复杂度：
     * 空间复杂度：
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        if (num < 2) {
            return true;
        }
        //此处类型需为long，否则会报超出时间范围的异常
        //如果想要使用int类型，可以使用模余的思路来做
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

    /**
     * 牛顿迭代
     * 时间复杂度：
     * 空间复杂度：
     * @param num
     * @return
     */
    public boolean isPerfectSquare1(int num) {
        if (num < 2) return true;
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return (x * x == num);
    }
}
