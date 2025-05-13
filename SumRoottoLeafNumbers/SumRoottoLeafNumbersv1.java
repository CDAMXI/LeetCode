package SumRoottoLeafNumbers;

import _srccode.*;

public class SumRoottoLeafNumbersv1 {
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
        if (root.left == null && root.right == null) {return sum;}
        if (root.left != null) {
            root.left.val += (root.val * 10);
            return dfs(root.left, root.left.val);
        }
        if (root.right != null) {
            root.right.val += (root.val * 10);
            return dfs(root.right, root.right.val);
        }
        return -1;
    }
}
