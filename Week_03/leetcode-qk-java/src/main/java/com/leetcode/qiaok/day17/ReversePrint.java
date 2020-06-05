package com.leetcode.qiaok.day17;

import java.util.Arrays;
import java.util.Stack;

/**
 *
 * 面试题06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * 限制：
 * 0 <= 链表长度 <= 10000
 *
 *
 * @since 2020-06-05
 * @author qiaok
 */
public class ReversePrint {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        ReversePrint test = new ReversePrint();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next  = new ListNode(2);
        long start = System.currentTimeMillis();
        int[] res = test.reversePrint(head);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res=" + Arrays.toString(res));

    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * @param head
     * @return
     */
    private int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
