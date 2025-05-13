package Triangle;

import java.util.*;

public class Trianglev1 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(-1));
        triangle.add(Arrays.asList(2, 3));
        triangle.add(Arrays.asList(1, -1, -3));
        System.out.println("Result: "+minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle){
        int cont = 0;
        if (triangle.size() == 1) {return triangle.get(0).get(0);}
        if (triangle.isEmpty()) {return cont;}
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            row.sort(Comparator.naturalOrder());
            cont += row.get(0);
        }
        return cont;
    }
}
