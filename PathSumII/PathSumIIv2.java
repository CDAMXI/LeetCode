package PathSumII;

import java.util.*;
import _srccode.*;

public class PathSumIIv2 {
    public static void main(String[] args) {
        Integer[] nodes = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode root = buildTree(nodes);
        System.out.println(pathSum(root,22));
        Integer[] node = {1,2,3};
        root = buildTree(node);
        System.out.println(pathSum(root,5));
        Integer[] node1 = {1,2};
        root = buildTree(node1);
        System.out.println(pathSum(root,0));
        root = buildTree(node1);
        System.out.println(pathSum(root,3));
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPaths(root, targetSum, currentPath, result);
        return result;
    }

    private static void findPaths(TreeNode node, int targetSum, List<Integer> currentPath, List<List<Integer>> result) {
        // If the node is null, we return
        if (node == null) {
            return;
        }

        // Add the current value to the path
        currentPath.add(node.val);

        // Check if we are in a leaf and the path sums the targetSum
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath)); // Add a copy of the current path to the result
        } else {
            // Continue exploring the children
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }

        // Backtrack: remove the current node from the path
        currentPath.remove(currentPath.size() - 1);
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
