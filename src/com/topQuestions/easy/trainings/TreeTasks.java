package com.topQuestions.easy.trainings;

import java.util.*;

public class TreeTasks {
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
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(11);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(15);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        TreeNode root2 = new TreeNode(7);
        root2.left = node1;
        root2.right = node2;


        //recursiveBinaryTreeTraversal(root);
        //inorderTreeTraversal(root);
        //broadFirstBinaryTreeTraversal(root);
        //System.out.println(rangeSumOfBST(root, 5, 8));
        //System.out.println(findModeInBinarySearchTree(root));
        //System.out.println(sameTree(root, root2));
        //System.out.println(symmetricTree(root));
        //closestBinarySearchTreeValue(root, 5);
        System.out.println(maximumDepthOfBinaryTree(root));
    }

    private static int maximumDepthOfBinaryTree(TreeNode root) {
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode current = queue.poll();

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.left != null) {
                    queue.offer(current.right);
                }

                size--;
            }

            depth++;
        }

        return depth;
    }


    private static void recursiveBinaryTreeTraversal(TreeNode current) {
        if (current == null) {
            return;
        }

        recursiveBinaryTreeTraversal(current.left);
        System.out.println(current.val);
        recursiveBinaryTreeTraversal(current.right);
    }


    private static void inorderTreeTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.println(current.val);
                current = current.right;
            }
        }
    }

    private static void broadFirstBinaryTreeTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.println(current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.left != null) {
                queue.offer(current.right);
            }
        }
    }

    private static int rangeSumOfBST(TreeNode root, int start, int end) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            int currValue = current.val;
            if (currValue >= start && currValue <= end) {
                sum += currValue;
            }

            if (current.left != null && currValue > start) {
                queue.offer(current.left);
            }

            if (current.right != null && currValue < end) {
                queue.offer(current.right);
            }
        }

        return sum;
    }

    private static int findModeInBinarySearchTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<Integer, Integer> stats = new HashMap<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            stats.put(curr.val, stats.getOrDefault(curr.val, 0) + 1);

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        return stats.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    private static boolean sameTree(TreeNode root1, TreeNode root2) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.poll();
            TreeNode curr2 = queue.poll();

            if (curr1 == null && curr2 == null) {
                continue;
            }

            if (curr1 == null || curr2 == null || curr1.val != curr2.val) {
                return false;
            }

            queue.offer(curr1.left);
            queue.offer(curr2.left);
            queue.offer(curr1.right);
            queue.offer(curr2.right);
        }

        return true;
    }

    private static boolean symmetricTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr1 = queue.poll();
            TreeNode curr2 = queue.poll();

            if (curr1 == null && curr2 == null) {
                continue;
            }

            if (curr1 != null || curr2 != null) {
                return false;
            }

            queue.offer(curr1.left);
            queue.offer(curr2.right);
            queue.offer(curr1.right);
            queue.offer(curr2.left);
        }

        return true;
    }


    private static int closestBinarySearchTreeValue(TreeNode root, int target) {
        int result = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (isCloserToTarget(result, current.val, target)) {
                result = current.val;
            }

            //if (current.val > target && current.left != null) {
            if (current.val > target && current.left != null) {
                queue.offer(current.left);
            }

            //if (current.val < target && current.right != null) {
            if (current.val < target && current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }

    private static boolean isCloserToTarget(int currentResult, int candidate, double target) {
        double currentResultDiff = Math.abs(target - currentResult);
        double candidateDiff = Math.abs(target - candidate);

        boolean result = candidateDiff < currentResultDiff;

        if (currentResultDiff == candidateDiff) {
            result = candidate < currentResult;
        }

        return result;
    }
}
