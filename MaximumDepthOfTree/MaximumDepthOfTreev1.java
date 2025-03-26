import srccode.*;

public class MaximumDepthOfTreev1 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);

        System.out.println(maxDepth(tr));
    }

    public static int maxDepth(TreeNode root){
        if (root.left != null && root.right != null) {
            return 1 + maxDepth(root.left) + maxDepth(root.right);
        }
        if (root.left != null && root.right != null) {
            return 1 + maxDepth(root.left);
        }
        if (root.right != null && root.left != null) {
            return 1 + maxDepth(root.right);
        }
        return 0;
    }
}
