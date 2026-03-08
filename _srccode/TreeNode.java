package _srccode;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    // Builds a binary tree from a level-order array. Use `null` for missing nodes.
    public static TreeNode buildTree(Integer[] nums) {
        if (nums == null || nums.length == 0 || nums[0] == null) return null;

        TreeNode root = new TreeNode(nums[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < nums.length) {
            TreeNode current = queue.poll();
            if (nums[i] != null) {
                current.left = new TreeNode(nums[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < nums.length && nums[i] != null) {
                current.right = new TreeNode(nums[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    // Optional: print the tree in level-order for visualization
    public void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add("null");
                continue;
            }
            result.add(String.valueOf(node.val));
            queue.offer(node.left);
            queue.offer(node.right);
        }

        // Trim trailing nulls
        int j = result.size() - 1;
        while (j >= 0 && result.get(j).equals("null")) j--;
        result = result.subList(0, j + 1);

        System.out.println(result);
    }
}
