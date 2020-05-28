package com.leetcode.qiaok.day11;

import java.util.*;

/**
 * 590. N叉树的后序遍历
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 * @since 2020-05-28
 * @author qiaok
 */
public class PostOrder {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        PostOrder test = new PostOrder();
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
        List<Integer> res = test.postOrder1(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res.toString());
    }

    /**
     * 递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    private List<Integer> postOrder(Node root) {
        List<Integer> data = new LinkedList<>();
        post(root,data);
        return data;
    }

    private void post(Node root, List<Integer> data) {
        if(root!=null){
            List<Node> children = root.children;
            if(children!=null){
                for (Node node :children) {
                    post(node,data);
                }
            }
            data.add(root.val);
        }
    }

    /**
     * 迭代
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     * @param root
     * @return
     */
    private List<Integer> postOrder1(Node root) {
        List<Integer> data = new LinkedList<>();
        Deque<Node> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            Node node = stack.pollLast();
            List<Node> children = node.children;
            if(children!=null&&children.size()>0){
                stack.addAll(children);
            }
            data.add(node.val);
        }
        return data;
    }


}

