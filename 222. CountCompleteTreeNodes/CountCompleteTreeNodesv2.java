import _srccode.*;

public class CountCompleteTreeNodesv2 {
    public static void main(String[] args){
        TreeNode tn = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6});
        System.out.print("Input: ");
        tn.printTree(tn); // [1,2,3,4,5,6]
        System.out.println("Output: " + countNodes(tn)); // Expected: 6
    }

    public static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = getDepth(root, true);
        int rightDepth = getDepth(root, false);

        if (leftDepth == rightDepth) {
            // Perfect binary tree node count formula
            return (1 << leftDepth) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    // Helper to compute depth by going either left or right
    private static int getDepth(TreeNode node, boolean goLeft) {
        int depth = 0;
        while (node != null) {
            node = goLeft ? node.left : node.right;
            depth++;
        }
        return depth;
    }
}
