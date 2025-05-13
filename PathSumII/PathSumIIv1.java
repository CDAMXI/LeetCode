package PathSumII;

import java.util.*;
import _srccode.*;
public class PathSumIIv1 {
    public static void main(String[] args) {
        
    }

    
    public static List<Integer> pathSum(TreeNode root, int targetSum) {
        List<Integer> list = new ArrayList<Integer>();
        return pathSum(root, targetSum, list);
    }

    public static List<Integer> pathSum(TreeNode root, int targetSum, List<Integer> list) {
        // If node is null, there is no path to sum
        if (root == null) {return list;}

        // If we are in a leaf, we check if the sum matches targetSum
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {return list;}
        }
        //return pathSum(root.left, targetSum - root.val, list)
        //(pathSum(root.right, targetSum - root.val, list));
        return list;
    }
}
