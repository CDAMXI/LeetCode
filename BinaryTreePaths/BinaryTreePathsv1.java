package BinaryTreePaths;

import java.util.*;
import zrccode.*;

public class BinaryTreePathsv1 {
    public static void main(String[] args) {
        
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths(root, "" + root,new ArrayList<String>());
    }

    public static List<String> binaryTreePaths(TreeNode root, String state, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(root.val + "");
            return list;
        }
        return binaryTreePaths(root.left, state + "->" + root.left, list);
    }
}
