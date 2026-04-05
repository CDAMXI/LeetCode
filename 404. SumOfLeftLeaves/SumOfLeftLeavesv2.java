import _srccode.*;

public class SumOfLeftLeavesv2 {
    public static void main(String[] args) {
        System.out.println("Sum of left leaves: " + sumOfLeftLeaves(TreeNode.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null){return 0;}

        int sum = 0;

        // Check if the left child is a leaf
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        // Recur on both subtrees
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
    }
}
