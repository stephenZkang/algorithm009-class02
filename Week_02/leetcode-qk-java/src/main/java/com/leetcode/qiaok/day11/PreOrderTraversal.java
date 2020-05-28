package com.leetcode.qiaok.day11;

import com.leetcode.qiaok.day09.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 * 难度：中等
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 前序是中左右
 * @since 2020-05-28
 * @author qiaok
 */
public class PreOrderTraversal {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        PreOrderTraversal test = new PreOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        long start = System.currentTimeMillis();
        List<Integer> res = test.preOrderTraversal(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 前序 中左右
     * 前、中、右序是指根的顺序
     * 递归
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> data = new LinkedList<>();
        preOrder(root,data);
        return data;
    }

    private void preOrder(TreeNode root, List<Integer> data) {
        if(root!=null){
            data.add(root.val);
            if(root.left!=null){
                preOrder(root.left,data);
            }

            if(root.right!=null){
                preOrder(root.right,data);
            }
        }

    }

    /**
     * 迭代
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> data = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode treeNode = stack.pollLast();
            data.add(treeNode.val);
            if(treeNode.left!=null){
                stack.add(treeNode.left);
            }
            if(treeNode.right!=null){
                stack.add(treeNode.right);
            }
        }
        return data;
    }

}
