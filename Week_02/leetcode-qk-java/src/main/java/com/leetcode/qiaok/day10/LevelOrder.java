package com.leetcode.qiaok.day10;

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
 * @since 2020-05-27
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
    private List<List<Integer>> result = new ArrayList<>();

    /**
     * 递归
     * 时间复杂度:
     * 空间复杂度：
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder(Node root) {
        if (root != null) level(root, 0);
        return result;
    }

    private void level(Node node, int level) {
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        if(node.children!=null){
            for (Node child : node.children) {
                level(child, level + 1);
            }
        }

    }

    /**
     * 利用队列实现广度优先搜索
     * 时间复杂度:O（n）
     * 空间复杂度：O（n）
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder1(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.val);
                if(node.children!=null){
                    queue.addAll(node.children);
                }
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 简化的广度优先搜索
     * 时间复杂度:O（n）
     * 空间复杂度：O（n）
     * @param root
     * @return
     */
    private List<List<Integer>> levelOrder2(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Node> previousLayer = Arrays.asList(root);

        while (!previousLayer.isEmpty()) {
            List<Node> currentLayer = new ArrayList<>();
            List<Integer> previousVals = new ArrayList<>();
            for (Node node : previousLayer) {
                previousVals.add(node.val);
                if(node.children!=null){
                    currentLayer.addAll(node.children);
                }

            }
            result.add(previousVals);
            previousLayer = currentLayer;
        }

        return result;

    }
}
