package CombinationSumII;

import java.util.*;

public class CombinationSumIIv2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // Crucial step to avoid duplicates
        combinationSumHelper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private static void combinationSumHelper(int[] candidates, int remaining, int start, List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate elements
            if (i > start && candidates[i] == candidates[i-1]) continue;
            
            if (candidates[i] > remaining){break;} // We can exit early thanks to sorting
            
            current.add(candidates[i]);
            combinationSumHelper(candidates, remaining - candidates[i], i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}
