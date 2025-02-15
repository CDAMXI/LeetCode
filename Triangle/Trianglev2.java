package Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trianglev2 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println("Result: "+minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n]; 
        
        // Copiamos la última fila en dp
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }
        
        // Iteramos desde la penúltima fila hacia arriba
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0]; // El resultado final estará en dp[0]
    }
}
