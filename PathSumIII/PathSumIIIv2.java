import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PathSumIIIv2 {
    public static void main(String[] args){
        Integer[] nodes = {10,5,-3,3,2,null,11,3,-2,null,1};
        TreeNode tree = buildTree(nodes);
        System.out.println("Result: " + pathSum(tree, 8));
        Integer[] nodes1 = {5,4,8,11,null,13,4,7,2,null,null,5,1};
        tree = buildTree(nodes1);
        System.out.println("Result: " + pathSum(tree,   22));
        Integer[] nodes2 = {1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000};
        tree = buildTree(nodes2);
        System.out.println("Result: " + pathSum(tree, 0));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        return countPaths(root, targetSum, new ArrayList<>());
    }

    private static int countPaths(TreeNode node, int targetSum, List<Integer> currentPath) {
        if (node == null) {
            return 0;
        }

        // Add the current value to the path
        currentPath.add(node.val);
        int pathCount = 0, sum = 0;

        // Verify paths ending in this node
        for (int i = currentPath.size() - 1; i >= 0; i--) {
            sum += currentPath.get(i);
            if (sum == targetSum) {
                pathCount++;
            }
        }

        // Explore children
        pathCount += countPaths(node.left, targetSum, currentPath);
        pathCount += countPaths(node.right, targetSum, currentPath);

        // Backtrack to keep the list reusable
        currentPath.remove(currentPath.size() - 1);
        
        return pathCount;
    }

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        // Create the root node
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            // Add right child
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
