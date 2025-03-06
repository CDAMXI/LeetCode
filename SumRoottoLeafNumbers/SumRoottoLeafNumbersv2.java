package SumRoottoLeafNumbers;

public class SumRoottoLeafNumbersv2 {
    public static void main(String[] args) {
        System.out.println("Sum Root to Leaf Numbers");
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    public static int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        
        // Calcula el valor acumulado hasta el nodo actual
        sum = sum * 10 + root.val;
        
        // Si es un nodo hoja, devuelve el valor acumulado
        if (root.left == null && root.right == null) {
            return sum;
        }
        
        // Recursivamente suma los valores de los subárboles izquierdo y derecho
        return dfs(root.left, sum) + dfs(root.right, sum);
    }
}
