package BalancedTree;

public class BalancedTreev2 {
    public static void main(String[] args) {
        // Árbol balanceado
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);
        System.out.println(isBalanced(tr));  // Debe devolver true
        
        // Árbol no balanceado
        tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(2);
        tr.left.left = new TreeNode(3);
        tr.left.right = new TreeNode(3);
        tr.left.left.left = new TreeNode(4);
        tr.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(tr));  // Debe devolver false
    }

    // Método para verificar si el árbol está balanceado
    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;  // Si la altura es -1, el árbol no está balanceado
    }

    // Método auxiliar para obtener la altura del árbol y verificar si está balanceado
    private static int height(TreeNode root) {
        if (root == null) {
            return 0;  // La altura de un nodo nulo es 0
        }

        // Calcular la altura de los subárboles izquierdo y derecho
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Si algún subárbol no está balanceado, devolver -1
        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        // Si la diferencia de alturas es mayor a 1, devolver -1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Retornar la altura máxima de los subárboles + 1 para el nodo actual
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
