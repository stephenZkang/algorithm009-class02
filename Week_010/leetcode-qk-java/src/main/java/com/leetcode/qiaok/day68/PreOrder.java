package com.leetcode.qiaok.day68;

import java.util.ArrayList;
import java.util.List;

/**
 * 589. N叉树的前序遍历
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 *
 * @since 2020-06-26
 * @author qiaok
 */
public class PreOrder {

    public static void main(String[] args){
        PreOrder test = new PreOrder();
        Node f21 = new Node(5);
        Node f22 = new Node(6);
        List<Node> list2 = new ArrayList<Node>();
        list2.add(f21);list2.add(f22);

        Node f11 = new Node(3,list2);
        Node f12 = new Node(2);
        Node f13 = new Node(4);
        List<Node> list = new ArrayList<Node>();
        list.add(f11);list.add(f12);list.add(f13);

        Node node = new Node(1,list);
        long start = System.currentTimeMillis();
        List<Integer> res =  test.preOrder(node);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res"+res);

    }

    /**
     * 时间复杂度：
     * 空间复杂度：
     * @param root
     * @return
     */
    public List<Integer> preOrder(Node root) {
        List<Integer> data = new ArrayList<Integer>();
        preOrder1(root,data);
        return data;
    }

    private void preOrder1(Node node, List<Integer> data) {
        if(node!=null){
            data.add(node.val);
        }
        if(node.children!=null){
            for (Node child:node.children) {
                preOrder1(child,data);
            }
        }
    }
}
