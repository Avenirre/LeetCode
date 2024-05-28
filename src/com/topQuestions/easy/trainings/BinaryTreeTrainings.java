package com.topQuestions.easy.trainings;

import com.topQuestions.utils.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeTrainings {

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
        //bfs(root);
        //System.out.println(rangeSumOfBST(root, 2, 9));
        //System.out.println(findModeInBinarySearchTree(root));
        //System.out.println(sameTree(root, root));
        //System.out.println(symmetricTree(root));
        //System.out.println(closeBinarySearchTreeValue(root, 14));
        //System.out.println(maximumDepthOfBinaryTree(root));
        //invertBinaryTree(root);
        //System.out.println(twoSum(root, 11));
    }

    private static boolean twoSum(TreeNode root, int target) {
        Set<Integer> numbers = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (numbers.contains(target - current.val)) {
                return true;
            }

            numbers.add(current.val);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }
        return false;
    }

    private static void invertBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);

            TreeNode temp = node1;
            node1 = node2;
            node2 = temp;
        }

    }

    //        7
    //    3       12
    //
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

                if (current.right != null) {
                    queue.offer(current.right);
                }
                size--;
            }
            depth++;
        }

        return depth;
    }

    private static int closeBinarySearchTreeValue(TreeNode root, int target) {

        int result = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int currentValue = current.val;

            if (currentValue == target) {
                return target;
            }

            if (Math.abs(result - target) > Math.abs(currentValue - target)) {
                result = current.val;
            }

            if (currentValue > target && current.left != null) {
                queue.offer(current.left);
            } else if (currentValue < target && current.right != null) {
                queue.offer(current.right);
            }
        }

        return result;
    }

    private static boolean symmetricTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode current1 = queue.poll();
            TreeNode current2 = queue.poll();

            if (current1 == null && current2 == null) {
                continue;
            }

            if (current1 == null || current2 == null || current1.val != current2.val) {
                return false;
            }

            queue.offer(current1.left);
            queue.offer(current2.right);
            queue.offer(current1.right);
            queue.offer(current2.left);
        }

        return true;

    }

    private static boolean sameTree(TreeNode root1, TreeNode root2) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        while (!queue.isEmpty()) {
            TreeNode current1 = queue.poll();
            TreeNode current2 = queue.poll();

            if (current1 == null && current2 == null) {
                continue;
            }

            if ((current1 == null || current2 == null) || current1.val != current2.val) {
                return false;
            }

            queue.offer(current1.left);
            queue.offer(current2.left);
            queue.offer(current1.right);
            queue.offer(current2.right);
        }

        return true;




    }

    private static Set<Integer> findModeInBinarySearchTree(TreeNode root) {

        Map<Integer, Integer> stats = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            stats.put(current.val, stats.getOrDefault(current.val, 0) + 1);

            if (current.left != null) {
                queue.offer(current.left);
            }

            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        int max = stats.entrySet().stream().mapToInt(Map.Entry::getValue).max().orElse(-1);

        return stats.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey).collect(Collectors.toSet());
    }

    private static int rangeSumOfBST(TreeNode root, int from, int to) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val >= from && current.val <= to) {
                result += current.val;
            }

            if (current.val >= from && current.left != null) {
                    queue.offer(current.left);
            }

            if (current.val <= to && current.right != null) {
                    queue.offer(current.right);
            }
        }

        return result;
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
