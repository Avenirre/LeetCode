package com.topQuestions.easy.trainings;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTrainings {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        //recursiveTraversal(root);
        bfs(root);
    }

    private static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            System.out.println(currentNode);

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }
    }

    private static void recursiveTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println(root);
        recursiveTraversal(root.left);
        recursiveTraversal(root.right);
    }
}
