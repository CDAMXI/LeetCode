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
        if (intervals.length <= 1) {
            return intervals;
        }

        // Ordenar los intervalos por su inicio
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();

        // Inicializar con el primer intervalo
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                // Fusionar los intervalos
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // Agregar nuevo intervalo
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
