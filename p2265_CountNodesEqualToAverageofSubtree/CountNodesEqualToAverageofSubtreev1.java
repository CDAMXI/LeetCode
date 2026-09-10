package p2265_CountNodesEqualToAverageofSubtree;
public class CountNodesEqualToAverageofSubtreev1{
    public static void main(String[] args){
        Integer[] root = {4, 8, 5, 0, 1, null, 6};
        TreeNode tree = TreeNode.buildTree(root);
        CountNodesEqualToAverageofSubtreev1 solution = new CountNodesEqualToAverageofSubtreev1();
        System.out.println(solution.averageOfSubtree(tree));
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        if(root.left == null && root.right == null) return root.val;

        int leftCount = averageOfSubtree(root.left);
        int rightCount = averageOfSubtree(root.right);

        double average = (leftCount + rightCount + root.val) / (countOfSubtree(root));

        return leftCount + rightCount + (root.val == (int) Math.floor(average) ? 1 : 0);
    }

    public static int countOfSubtree(TreeNode root) {
        if (root == null) return 0;

        return 1 + countOfSubtree(root.left) + countOfSubtree(root.right);
    }
}
