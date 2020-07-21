package com.leetcode.qiaok.day64;

/**
 * 83. 删除排序链表中的重复元素
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * 通过次数
 *
 * @since 2020-07-21
 * @author qiaok
 */
public class DeleteDuplicates {

    public static void main(String[] args){
        DeleteDuplicates test = new DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        long start = System.currentTimeMillis();
        ListNode res = test.deleteDuplicates(head);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     *
     * 时间复杂度：
     * 空间复杂度：
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }
}
