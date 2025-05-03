import srccode.*;

public class CountCompleteTreeNodesv1 {
    public static void main(String[] args){
        TreeNode tn = TreeNode.buildTree(new Integer[]{1,2,3,4,5,6});
        System.out.print("Input: ");
        tn.printTree(tn); // [1,2,3,4,5,6]
        System.out.println("Output: " + countNodes(tn)); // 6
    }

    public static int countNodes(TreeNode root){
        if (root == null){return 0;}
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
