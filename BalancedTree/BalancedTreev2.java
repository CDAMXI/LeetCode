package BalancedTree;

import srccode.*;

public class BalancedTreev2 {
    public static void main(String[] args) {
        // Balanced Tree
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);
        System.out.println(isBalanced(tr));  // Must return true
        
        // Non-balanced Tree
        tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(2);
        tr.left.left = new TreeNode(3);
        tr.left.right = new TreeNode(3);
        tr.left.left.left = new TreeNode(4);
        tr.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(tr));  // Must return false
    }

    // Method to check if the tree is balanced
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;  // Si la altura es -1, el árbol no está balanceado
    }

    // Auxliar method to get the height of the tree and check if it is balanced
    private static int height(TreeNode root) {
        if (root == null) {
            return 0;  // The hight of a null node is 0
        }

        // Cacluate the hgiht of the left and right subtrees
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // If a subtree is not balanced, return -1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // If the difference in heights is greater than 1, return -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the maximum height of the subtrees + 1 for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
