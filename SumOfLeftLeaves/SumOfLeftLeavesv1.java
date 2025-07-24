import _srccode.*;

public class SumOfLeftLeavesv1{
    public static void main(String[] args) {
        System.out.println("Sum of left leaves: " + sumOfLeftLeaves(TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7})));
    }

    public static int sumOfLeftLeaves(TreeNode root){
        if(root == null){return 0;}
        if(root.left == null && root.right == null){
            return 0; // It's a leaf node, but not a left leaf
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right); // It's a left leaf
        }
        return 0; // Not a left leaf, continue searching
    }
}
