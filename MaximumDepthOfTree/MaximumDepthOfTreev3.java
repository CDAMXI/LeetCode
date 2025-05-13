import java.util.*;
import _srccode.*;

public class MaximumDepthOfTreev3 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);

        System.out.println(maxDepth(tr));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
    
        // Use a stack to simulate an iterative DFS traversal
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
    
        stack.push(root);
        depths.push(1); // The initial depth of the root node is 1
    
        int maxDepth = 0;
    
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int currentDepth = depths.pop();
    
            // Update the maximum depth
            maxDepth = Math.max(maxDepth, currentDepth);
    
            // Add the children to the stack along with their respective depths
            if (node.left != null) {
                stack.push(node.left);
                depths.push(currentDepth + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                depths.push(currentDepth + 1);
            }
        }
    
        return maxDepth;
    }
}
