import _srccode.*;

public class MaximumDepthOfTreev2v1 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);

        System.out.println(maxDepth(tr));
    }

    public static int maxDepth(TreeNode root) {
        // Base case: If the node is null, the depth is 0
        if (root == null) {
            return 0;
        }
    
        // Get the maximum depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
    
        // The maximum depth of the current tree is 1 (current node) + the greater depth of the children
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
