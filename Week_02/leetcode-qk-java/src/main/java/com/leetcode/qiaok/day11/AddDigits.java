package com.leetcode.qiaok.day11;

/**
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 *
 * 示例:
 *
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 * @since 2020-05-28
 * @author qiaok
 */
public class AddDigits {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        AddDigits test = new AddDigits();
        int num = 38;
        long start = System.currentTimeMillis();
        int res = test.addDigits1(num);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);

    }

    /**
     * 递归
     * 时间复杂度： O（n）
     * 空间复杂度: O(1)
     * @param num
     * @return
     */
    private int addDigits(int num) {
        if (num < 10) {
            return num;
        }
        int sum = 0;
        while(num!=0){
            int n = num%10;
            sum += n;
            num /= 10;
        }
        return addDigits(sum);
    }

    /**
     * 数学
     * 时间复杂度： O（n）
     * 空间复杂度: O(1)
     * @param num
     * @return
     */
    private int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }

}
