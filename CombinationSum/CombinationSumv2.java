import java.util.*;

public class CombinationSumv2 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) continue; // Use continue instead of break if it's not sorted
            
            // Avoid creating a new list in each iteration
            current.add(candidates[i]);
            combinationSumHelper(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
