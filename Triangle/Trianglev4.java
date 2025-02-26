package Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trianglev4 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println("Result: "+minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();

    // Access elements directly to reduce calls to get()
    for (int i = n - 2; i >= 0; i--) {  
        List<Integer> currentRow = triangle.get(i);
        List<Integer> nextRow = triangle.get(i + 1);

        for (int j = 0; j <= i; j++) {
            int minValue = nextRow.get(j) < nextRow.get(j + 1) ? nextRow.get(j) : nextRow.get(j + 1);
            currentRow.set(j, currentRow.get(j) + minValue);
        }
    }

    return triangle.get(0).get(0);
}

}
