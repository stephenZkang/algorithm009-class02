package com.leetcode.qiaok.day11;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *  589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 * @since 2020-05-28
 * @author qiaok
 */
public class PreOrder {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        PreOrder test = new PreOrder();
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
        List<Integer> res = test.preOrder1(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res.toString());
    }

    /**
     * 递归
     * @param root
     * @return
     */
    private List<Integer> preOrder(Node root) {
        List<Integer> data = new LinkedList<>();
        pre(root,data);
        return data;
    }

    private void pre(Node root, List<Integer> data) {
        if(root!=null){
            data.add(root.val);
            if(root.children!=null){
                for (Node node :root.children) {
                    pre(node,data);
                }
            }
        }
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    private List<Integer> preOrder1(Node root) {
        List<Integer> data = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            data.add(node.val);
            if(node.children!=null){
                for (Node n : node.children) {
                    stack.add(n);
                }
            }
        }
        return data;
    }


}
