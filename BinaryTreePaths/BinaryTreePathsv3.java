package BinaryTreePaths;

import java.util.*;

public class BinaryTreePathsv3 {
    public static void main(String[] args) {
        Integer[] values = {1, 2, 3, null, 5};
        TreeNode tn = createTreeFromArray(values);
        System.out.println(binaryTreePaths(tn));
        Integer[] values1 = {1};
        tn = createTreeFromArray(values1);
        System.out.println(binaryTreePaths(tn));
    }
    
    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null) {
            findPaths(root, new StringBuilder(), result);
        }
        return result;
    }

    private static void findPaths(TreeNode node, StringBuilder path, List<String> result) {
        int lengthBefore = path.length();  // Guardar el estado actual del StringBuilder
        path.append(node.val);  // Agregar el valor actual

        if (node.left == null && node.right == null) {
            result.add(path.toString());  // Agregar el camino completo al resultado
        } else {
            path.append("->");  // Agregar la flecha solo si hay hijos
            if (node.left != null) {
                findPaths(node.left, path, result);
            }
            if (node.right != null) {
                findPaths(node.right, path, result);
            }
        }
        path.setLength(lengthBefore);  // Restaurar el estado original del StringBuilder
    }

    private static TreeNode createTreeFromArray(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return null;
        }
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();

            if (values[i] != null) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;

            if (i < values.length && values[i] != null) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

}
