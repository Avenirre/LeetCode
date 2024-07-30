package mainAlgorythms;

import java.util.Stack;

public class BinaryTree {

    public void traversePreOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        stack.push(root);
        while(!stack.isEmpty()) {
            current = stack.pop();
            //do something with the value

            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public void traverseInOrderWithoutRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            //do something with the value
            current = top.right;
        }
    }

    class TreeNode {
        public TreeNode left;
        public TreeNode right;
        public int value;
    }
}
