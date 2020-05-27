package com.leetcode.qiaok.day09;


import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 中序：左中右
 *
 * @since 2020-05-27
 * @author qiaok
 */
public class InorderTraversal {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InorderTraversal test = new InorderTraversal();
        List<Integer> res = test.inorderTraversal1(root);
        System.out.println("res="+res.toString());
    }

    /**
     * 递归
     * @param root
     * @return
     */
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if(root ==null){
            return;
        }

        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    private List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if(root == null){
            return  list;
        }
        stack.add(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            if(node.left!=null){
                stack.add(node.left);
            }
            list.add(node.val);
            if(node.right!=null){
                stack.add(node.right);
            }
        }

        return list;
    }

}
