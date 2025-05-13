import zrccode.*;

public class MaximumDepthOfTreev2v2 {
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
    
        // The maximum depth of the current tree is 1 (current node) + the greater depth of the children
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
