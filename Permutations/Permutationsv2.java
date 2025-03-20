import java.util.ArrayList;
import java.util.List;

public class Permutationsv2{
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums.length <= 1) {
            list.add(nums[0]);
            result.add(list);
            return result;
        }
        list.clear();
        backtrack(result, list, nums);
        return result;
    }

    public static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums){
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue; // Avoids duplicates
            list.add(nums[i]);
            backtrack(result, list, nums);
            list.remove(list.size() - 1); // Backtrack
        }
    }
}
