import java.util.*;

public class mergeIntervalsv2 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
        System.out.println();
        
        int[][] intervals1 = {{1, 3}, {2, 9}, {8, 10}, {15, 18}};
        result = merge(intervals1);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        // If there are no intervals or only one, return the same array
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals by their start values
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        // Start with the first interval
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        // Iterate through the intervals
        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Merge intervals if they overlap
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // If there's no overlap, add the current interval to the result
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        // Convert the list of merged intervals to a 2D array
        return merged.toArray(new int[merged.size()][]);
    }
}
// Time Complexity: O(nlogn) where n is the number of intervals
// Space Complexity: O(n) where n is the number of intervals
