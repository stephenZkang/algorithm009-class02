package com.leetcode.qiaok.day10;

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
 * @since 2020-05-27
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
        List<Integer> res = test.preOrderTraversal1(root);
        System.out.println("耗时"+(System.currentTimeMillis() - start)+"毫秒");
        System.out.println("res="+res);
    }

    /**
     * 递归
     *
     * 时间复杂度：
     * 空间复杂度：O（n）
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        preOrder(root,list);
        return list;
    }

    private void preOrder(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

    /**
     * 迭代
     *
     * 时间复杂度：
     * 空间复杂度：O（n）
     * @param root
     * @return
     */
    private List<Integer> preOrderTraversal1(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pollLast();
            list.add(node.val);
            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }
        }
        return list;
    }
}
