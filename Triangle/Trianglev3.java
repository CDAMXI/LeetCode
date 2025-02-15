package Triangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trianglev3 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println("Result: "+minimumTotal(triangle));
    }
    
    public static int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();

    // Modificamos la última fila directamente para ahorrar espacio
    for (int i = n - 2; i >= 0; i--) {  
        for (int j = 0; j <= i; j++) {
            triangle.get(i).set(j, triangle.get(i).get(j) + 
                                Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        }
    }

    return triangle.get(0).get(0); // El resultado final estará en la cima del triángulo
}

}
