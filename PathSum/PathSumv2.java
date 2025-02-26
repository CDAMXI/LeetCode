package PathSum;

public class PathSumv2 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(3);
        System.out.println(hasPathSum(tr, 4)); // Output: true
        tr = null;
        System.out.println(hasPathSum(tr, 0)); // Output: false
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // If the node is null, there is no path to sum
        if (root == null) {return false;}

        // If we are in a leaf, we check if the sum matches targetSum
        if (root.left == null && root.right == null) {return root.val == targetSum;}
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
