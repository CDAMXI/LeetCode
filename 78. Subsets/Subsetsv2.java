package Subsets;

import java.util.*;

public class Subsetsv2 {
    public static void main(String[] args) {
        System.out.println(new Subsetsv2().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums); // optional
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        res.sort(Comparator.comparingInt(List::size));
        return res;
    }

    private void backtrack(int start, int[] nums, List<Integer> path, List<List<Integer>> res) {
        // Every partial combination is a valid subset
        res.add(new ArrayList<>(path));

        // Explore options from current index
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(i + 1, nums, path, res);
            path.remove(path.size() - 1);
        }
    }
}
