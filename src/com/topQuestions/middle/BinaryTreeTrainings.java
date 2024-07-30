package com.topQuestions.middle;

import java.util.*;

public class BinaryTreeTrainings {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10,
                new TreeNode(5, 
                        new TreeNode(2, null, null),
                        new TreeNode(7, null, null)),
                new TreeNode(15,
                        new TreeNode(12, null, null),
                        new TreeNode(17, null, null)));

        verticalOrderTraversal(root);
    }

    private static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Map<Integer, ArrayList<Integer>> columns = new HashMap<>();
        //TreeNode + its column number
                               //10
                  //5                     //15
              //column -1   //column 0    //column 1
        Queue<NodeColumnData> queue = new LinkedList<>();
        int column = 0;
        queue.add(new NodeColumnData(root, column));

        int minColumn = 0;
        int maxColumn = 0;

        while (!queue.isEmpty()) {
            NodeColumnData current = queue.poll();
            TreeNode currentNode = current.node;
            column = current.column;

            if (!columns.containsKey(column)) {
                columns.put(column, new ArrayList<Integer>());
            }
            columns.get(column).add(currentNode.val);
            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (currentNode.left != null) {
                queue.add(new NodeColumnData(currentNode.left, column - 1));
            }

            if (currentNode.right != null) {
                queue.add(new NodeColumnData(currentNode.right, column + 1));
            }
        }
        columns.forEach((key, value) -> System.out.println(key + ":" + value));


        for(int i = minColumn; i <= maxColumn; i++) {
            result.add(columns.get(i));
        }

        return result;
    }

    public static class NodeColumnData {

        public TreeNode node;

        public int column;

        public NodeColumnData(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }


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
}
