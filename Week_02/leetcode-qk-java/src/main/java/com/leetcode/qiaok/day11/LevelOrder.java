package com.leetcode.qiaok.day11;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 *
 * @since 2020-05-28
 * @author qiaok
 */
public class LevelOrder {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        LevelOrder test = new LevelOrder();
        List<Node> child = new ArrayList<>();
        List<Node> fchild = new ArrayList<>();
        Node ff = new Node(5);
        fchild.add(ff);
        Node fs = new Node(6);
        fchild.add(fs);
        Node first = new Node(3,fchild);
        child.add(first);
        child.add(new Node(2));
        child.add(new Node(4));
        Node root = new Node(1,child);
        long start = System.currentTimeMillis();
        List<List<Integer>> res = test.levelOrder(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res.toString());
    }

    /**
     *
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>  data = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                Node poll = stack.poll();
                level.add(poll.val);
                List<Node> children = poll.children;
                if(children!=null){
                    stack.addAll(children);
                }
            }
            data.add(level);
        }
        return data;
    }

}
