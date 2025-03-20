import java.util.*;

public class PermutationsIIv2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorts array to avoid duplicates
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list)); // Adds a copy of the current list
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // Evita duplicados
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            used[i] = true; // Marcks element as used
            list.add(nums[i]); // Adds element to current permutation
            backtrack(result, list, nums, used); // Recursive call
            list.remove(list.size() - 1); // Removes the last element (backtrack)
            used[i] = false; // Unmarcks the element to allow its use in other permutations
        }
    }
}
