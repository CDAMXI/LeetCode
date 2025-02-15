package PathSumII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        // Si el nodo es null, salimos
        if (node == null) {
            return;
        }

        // Agregar el valor actual al camino
        currentPath.add(node.val);

        // Verificar si estamos en una hoja y el camino suma el targetSum
        if (node.left == null && node.right == null && targetSum == node.val) {
            result.add(new ArrayList<>(currentPath)); // Agregar una copia del camino actual al resultado
        } else {
            // Continuar explorando los hijos
            findPaths(node.left, targetSum - node.val, currentPath, result);
            findPaths(node.right, targetSum - node.val, currentPath, result);
        }

        // Retroceder: eliminar el nodo actual del camino
        currentPath.remove(currentPath.size() - 1);
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
