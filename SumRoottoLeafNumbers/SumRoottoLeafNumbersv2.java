package SumRoottoLeafNumbers;

import zrccode.*;

public class SumRoottoLeafNumbersv2 {
    public static void main(String[] args) {
        System.out.println("Sum Root to Leaf Numbers");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    public static int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        // Calculating the accumulated value up to the current node
        sum = sum * 10 + root.val;
        
        // If it is a leaf node, return the accumulated value
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        // Add recursively the values of the left and right subtrees
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
