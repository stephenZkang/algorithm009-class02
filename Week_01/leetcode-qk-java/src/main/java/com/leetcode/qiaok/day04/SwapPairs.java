package com.leetcode.qiaok.day04;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @since 2020-05-21
 * @author qiaok
 */
public class SwapPairs {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        SwapPairs test = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        long start = System.currentTimeMillis();
        ListNode res = test.swapPair(head);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res=" + res);
    }

    /**
     *
     * @param head
     * @return
     */
    private ListNode swapPair(ListNode head) {
        if ((head == null) || (head.next == null)) {
            return head;
        }
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPair(secondNode.next);
        secondNode.next=firstNode;
        return secondNode;
    }
}
