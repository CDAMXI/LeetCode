package Combinations;

import java.util.*;

public class Combinationsv1{
    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        System.out.println(combine(n, k)); // Output: [[1, 2], [1, 3], [1, 4], [2, 3], [2, 4], [3, 4]]
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int start, int n, int k,
                                List<Integer> current,
                                List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }
}
