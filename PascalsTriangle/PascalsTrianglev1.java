package PascalsTriangle;

import java.util.*;

public class PascalsTrianglev1 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter the number of rows desired for Pascal's Triangle: ");
                int rows = kbd.nextInt();
                
                if (rows <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Pedir nuevamente un valor válido
                }

                List<List<Integer>> pascalTriangle = generate(rows);
                for (List<Integer> row : pascalTriangle) {
                    System.out.println(row);
                }

                isValid = true; // Se introduce un valor válido, salir del ciclo
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consumir el token inválido
            }
        }

        kbd.close(); // Cerrar el scanner al final
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(); // Lista principal
    
        if (numRows <= 0) {return result;} // Si no hay filas, retornar lista vacía
    
        // Primera fila de Pascal siempre es [1]
        result.add(new ArrayList<>(List.of(1)));
    
        // Construir las filas desde la segunda hasta numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1); // Fila anterior
            List<Integer> currentRow = new ArrayList<>();
    
            // Primer elemento de cada fila es 1
            currentRow.add(1);
    
            // Construir los elementos intermedios
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
    
            // Último elemento de cada fila es 1
            currentRow.add(1);
    
            // Agregar la fila actual al resultado
            result.add(currentRow);
        }
    
        return result;
    }
    
}
