import java.util.*;

public class mergeIntervalsv1 {
    public static void main(String[] args){

    }

    public static int[][] merge(int[][] intervals){
        List<List<Integer>> aux = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i < intervals.length - 1) {
                if (intervals[i][1] >= intervals[i+1][1]) {
                    aux.add(new ArrayList<>(List.of(intervals[i][intervals[i+1][1]])));
                }
            }
        }

        int[][] result = convertTo2DArray(aux);
        for (int i = 0; i < result.length; i++) {
            if (i < result.length - 1) {
                if (result[i][1] >= result[i+1][1]) {
                    aux.add(new ArrayList<>(List.of(result[i][result[i+1][1]])));
                }
            }
        }
        return result;
    }

    public static int[][] convertTo2DArray(List<List<Integer>> list) {
        int rows = list.size();
        int[][] array = new int[rows][];

        for (int i = 0; i < rows; i++) {
            List<Integer> currentRow = list.get(i);
            array[i] = new int[currentRow.size()];
            for (int j = 0; j < currentRow.size(); j++) {
                array[i][j] = currentRow.get(j);
            }
        }
        return array;
    }
}
