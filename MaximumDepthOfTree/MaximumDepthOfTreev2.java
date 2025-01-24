public class MaximumDepthOfTreev2 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);

        System.out.println(maxDepth(tr));
    }

    public static int maxDepth(TreeNode root) {
        // Caso base: Si el nodo es null, la profundidad es 0
        if (root == null) {
            return 0;
        }
    
        // Obtener la profundidad máxima de los subárboles izquierdo y derecho
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
    
        // La profundidad máxima del árbol actual es 1 (nodo actual) + mayor profundidad de los hijos
        return 1 + Math.max(leftDepth, rightDepth);
    }
    
}
