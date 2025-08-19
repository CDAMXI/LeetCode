package PathSum;

import _srccode.*;

public class PathSumv1 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(3);
        System.out.println(hasPathSum(tr, 5));
        tr = null;
        System.out.println(hasPathSum(tr, 0));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum){
        if (root == null) {return false;}
        if (root.val > targetSum) {return false;}
        else if(root.val == targetSum){return true;}
        if (root.left != null) {return hasPathSum(root.left, targetSum-root.val);}
        if (root.right != null) {return hasPathSum(root.right, targetSum-root.val);}
        return true;
    }
}
