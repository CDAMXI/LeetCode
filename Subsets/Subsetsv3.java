package Subsets;

import java.util.*;

public class Subsetsv3 {
    public static void main(String[] args) {
        System.out.println(new Subsetsv3().subsets(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        // Don't sort if you don't need to: saves time O(n log n)
        final int n = nums.length;
        final int total = 1 << n;              // 2^n subsets
        List<List<Integer>> res = new ArrayList<>(total);

        for (int mask = 0; mask < total; mask++) {
            int k = Integer.bitCount(mask);    //number of elements in this subset
            List<Integer> subset = new ArrayList<>(k);

            // goes bit by bit in mask
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            res.add(subset);
        }
        
        res.sort(Comparator.comparingInt(List::size));
        return res;
    }
}
