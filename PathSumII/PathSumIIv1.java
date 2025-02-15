package PathSumII;
import java.util.*;
public class PathSumIIv1 {
    public static void main(String[] args) {
        
    }

    
    public static List<Integer> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<Integer>();
        return pathSum(root, targetSum, list);
    }

    public static List<Integer> pathSum(TreeNode root, int targetSum, List<Integer> list) {
        // Si el nodo es null, no hay camino que sumar
        if (root == null) {return list;}

        // Si estamos en una hoja, verificamos si la suma coincide con targetSum
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {return list;}
        }
        //return pathSum(root.left, targetSum - root.val, list)
        //(pathSum(root.right, targetSum - root.val, list));
        return list;
    }
}
