package IntersectionOfTwoArraysII;

import java.util.*;

public class IntersectionOfTwoArraysIIv2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2))); // Output: [2, 2]
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        // Count frequencies of elements in nums1
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        // For each num in nums2, add to result if it exists in counts
        for (int num : nums2) {
            if (counts.getOrDefault(num, 0) > 0) {
                result.add(num);
                counts.put(num, counts.get(num) - 1); // Decrement count
            }
        }

        // Convert result to array
        int[] output = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            output[i] = result.get(i);
        }
        return output;
    }
}
