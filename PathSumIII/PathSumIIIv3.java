import java.util.*;

public class PathSumIIIv3 {
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
        System.out.println("Result: " + pathSum(tree, 2000000000));
    }

    public static int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: one way to have a sum of zero
        return findPaths(root, 0, targetSum, prefixSumCount);
    }

    private static int findPaths(TreeNode node, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCount) {
        if (node == null) {
            return 0;
        }

        currentSum += node.val;
        int pathCount = prefixSumCount.getOrDefault(currentSum - targetSum, 0);

        // Update the prefix sum count
        prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);

        // Recursively find paths in the left and right subtrees
        pathCount += findPaths(node.left, currentSum, targetSum, prefixSumCount);
        pathCount += findPaths(node.right, currentSum, targetSum, prefixSumCount);

        // Backtrack: remove the current sum from the map to avoid affecting other paths
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);

        return pathCount;
    }

    public static TreeNode buildTree(Integer[] nodes) {
        if (nodes == null || nodes.length == 0) {
            return null;
        }

        // Crear el nodo raíz
        TreeNode root = new TreeNode(nodes[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Agregar el hijo izquierdo
            if (nodes[i] != null) {
                current.left = new TreeNode(nodes[i]);
                queue.add(current.left);
            }
            i++;

            // Agregar el hijo derecho
            if (i < nodes.length && nodes[i] != null) {
                current.right = new TreeNode(nodes[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}
