package com.leetcode.qiaok.day10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
 * @since 2020-05-27
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
        List<Integer> res = test.postOrder(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res.toString());
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postOrder(Node root) {
        List<Integer> list = new LinkedList<>();
        post(root,list);
        return list;
    }

    private void post(Node root, List<Integer> list) {
        if(root!=null){
            if(root.children!=null&&root.children.size()>0){
                for (Node node :root.children) {
                    post(node,list);
                }
            }
            list.add(root.val);
        }
    }
}

