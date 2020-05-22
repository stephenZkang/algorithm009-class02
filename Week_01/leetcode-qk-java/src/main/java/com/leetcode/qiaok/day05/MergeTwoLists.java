package com.leetcode.qiaok.day05;

import com.leetcode.qiaok.day04.ListNode;

import java.util.Collections;

/**
 *   21. 合并两个有序链表
 *    将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *    难度：简单
 *    示例：
 *    输入：1->2->4, 1->3->4
 *    输出：1->1->2->3->4->4
 *
 * @since 2020-05-22
 * @author qiaok
 */
public class MergeTwoLists {


    /**
     * 测试
     * @param args
     */
    public static  void main(String[] args){
        MergeTwoLists test = new MergeTwoLists();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode( 1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        long start = System.currentTimeMillis();
        ListNode res = test.mergeTwoLists(l1,l2);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+ res);
    }

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param l1
     * @param l2
     * @return
     */
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return  l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
