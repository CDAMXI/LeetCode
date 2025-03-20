import java.util.ArrayList;
import java.util.List;

public class Permutationsv3 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list)); // Adds a copy of the current list
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]){continue;} // Avoids duplicates in O(1)
            used[i] = true; // Marcs the element as used
            list.add(nums[i]); // Adds the element to the current permutation
            backtrack(result, list, nums, used); // Recusive call
            list.remove(list.size() - 1); // Removes the last  (backtrack)
            used[i] = false; // Unmarcks the element to allow its use in other permutations
        }
    }
}
