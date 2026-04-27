package p57_InsertInterval;

import java.util.*;

public class InsertIntervalsv1 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        int[][] result = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(result));
    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        List<List<Integer>> list = new ArrayList<>();
        for (int[] interval : intervals) {
            List<Integer> row = new ArrayList<>();
            for (int val : interval) row.add(val);
            list.add(row);
        }
        list.sort((a, b) -> a.get(0) - b.get(0));
        list.add(Arrays.asList(newInterval[0], newInterval[1]));
        list.sort((a, b) -> a.get(0) - b.get(0));
        intervals = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            intervals[i][0] = list.get(i).get(0);
            intervals[i][1] = list.get(i).get(1);
        }
        return merge(intervals);
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
