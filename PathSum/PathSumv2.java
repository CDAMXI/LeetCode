package PathSum;

public class PathSumv2 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(3);
        System.out.println(hasPathSum(tr, 4)); // Output: true
        tr = null;
        System.out.println(hasPathSum(tr, 0)); // Output: false
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        // Si el nodo es null, no hay camino que sumar
        if (root == null) {return false;}

        // Si estamos en una hoja, verificamos si la suma coincide con targetSum
        if (root.left == null && root.right == null) {return root.val == targetSum;}
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
