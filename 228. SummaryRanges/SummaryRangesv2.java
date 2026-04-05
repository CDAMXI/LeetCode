package SummaryRanges;

import java.util.*;

public class SummaryRangesv2 {
    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges(new int[]{}));
        System.out.println(summaryRanges(new int[]{1}));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int start = nums[0];

        for (int i = 1; i <= nums.length; i++) {
            // Check if the current number breaks the sequence or we're at the end
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    result.add(String.valueOf(start));
                } else {
                    result.add("\""+start + "->" + nums[i - 1]+"\"");
                }
                // If not at the end, update the start of the next range
                if (i < nums.length) start = nums[i];
            }
        }

        return result;
    }
}
