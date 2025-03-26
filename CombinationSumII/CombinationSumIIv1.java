package CombinationSumII;

import java.util.*;

public class CombinationSumIIv1 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0 && !result.contains(current)) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        if (result.contains(current)) {return;}

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) continue; // Use continue instead of break if it's not sorted
            
            // Avoid creating a new list in each iteration
            current.add(candidates[i]);
            combinationSumHelper(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }
}
