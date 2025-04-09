import java.util.*;

public class mergeIntervalsv3 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = merge(intervals);
        for (int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by the start of each interval
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int index = 0;  // Points to the position of the merged interval

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[index][1] >= intervals[i][0]) {
                // Merge the current and next intervals
                intervals[index][1] = Math.max(intervals[index][1], intervals[i][1]);
            } else {
                // Move to the next interval
                index++;
                intervals[index] = intervals[i];
            }
        }

        // Return only the relevant portion of the array
        return Arrays.copyOf(intervals, index + 1);
    }
}
