package p2265_CountNodesEqualToAverageofSubtree;

public class CountNodesEqualToAverageofSubtreev2 {
    
    // Variable global para contar cuántos nodos cumplen la condición
    private int validNodesCount = 0;

    public static void main(String[] args) {
        Integer[] rootValues = {4, 8, 5, 0, 1, null, 6};
        TreeNode tree = TreeNode.buildTree(rootValues);
        
        CountNodesEqualToAverageofSubtreev1 solution = new CountNodesEqualToAverageofSubtreev1();
        System.out.println(solution.averageOfSubtree(tree)); // Debería imprimir: 5
    }

    public int averageOfSubtree(TreeNode root) {
        // Reiniciamos el contador (buena práctica si llamas al método varias veces)
        validNodesCount = 0; 
        dfs(root);
        return validNodesCount;
    }

    // El método retorna un arreglo: {suma_del_subarbol, cantidad_de_nodos}
    private int[] dfs(TreeNode node) {
        // Caso base: si el nodo es nulo, la suma es 0 y hay 0 nodos
        if (node == null) {
            return new int[]{0, 0};
        }

        // 1. Recorremos los hijos primero
        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // 2. Calculamos los datos del subárbol actual
        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;

        // 3. Verificamos la condición
        // Nota: En Java, la división de enteros (/) ya trunca los decimales hacia abajo automáticamente
        if (currentSum / currentCount == node.val) {
            validNodesCount++;
        }

        // 4. Pasamos los datos al nodo padre
        return new int[]{currentSum, currentCount};
    }
}
