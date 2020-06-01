package com.leetcode.qiaok.day15;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
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
 * @since 2020-06-01
 * @author qiaok
 */
public class InOrderTraversal {

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args){
        TreeNode root= new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        InOrderTraversal test = new InOrderTraversal();
        long start = System.currentTimeMillis();
        List<Integer> data  = test.inorderTraversal(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+data.toString());

    }

    /**
     * 递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> data = new LinkedList<Integer>();
        inorder(root,data);
        return data;
    }

    private void inorder(TreeNode root, List<Integer> data) {
        if(root == null) return;
        if(root.left !=null){
            inorder(root.left,data);
        }
        data.add(root.val);
        if(root.right != null){
            inorder(root.right,data);
        }
    }

    /**
     * 迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * @param root
     * @return
     */
    private List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> data = new LinkedList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pollLast();
            if(treeNode.left !=null){
                stack.add(treeNode.left);
            }
            data.add(treeNode.val);

            if(treeNode.right !=null){
                stack.add(treeNode.right);
            }
        }
        return data;
    }
}
