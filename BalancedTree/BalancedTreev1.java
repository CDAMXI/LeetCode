package BalancedTree;

import _srccode.*;

public class BalancedTreev1 {
    public static void main(String[] args) {
        TreeNode tr = new TreeNode(3);
        tr.left = new TreeNode(9);
        tr.right = new TreeNode(20);
        tr.right.left = new TreeNode(15);
        tr.right.right = new TreeNode(7);
        System.out.println(isBalanced(tr));
        tr = new TreeNode(1);
        tr.left = new TreeNode(2);
        tr.right = new TreeNode(2);
        tr.left.left = new TreeNode(3);
        tr.left.right = new TreeNode(3);
        tr.left.left.left = new TreeNode(4);
        tr.left.left.right = new TreeNode(4);
        System.out.println(isBalanced(tr));
    }

    public static boolean isBalanced(TreeNode root){
        if (root == null) {return true;}
        if(root.left == null && root.right == null){return true;}
        if(root.left != null && root.right != null){
            return (isBalanced(root.left)) && (isBalanced(root.right));
        }
        else{return false;}
    }

    
}
