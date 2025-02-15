package PascalsTriangle;

import java.util.*;

public class PascalsTrianglev2 {
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

        if (numRows <= 0){return result;} // Si no hay filas, retornar lista vacía

        // Primera fila siempre es [1]
        result.add(new ArrayList<>(List.of(1)));

        // Construir las filas desde la segunda hasta numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1); // Fila anterior
            List<Integer> currentRow = new ArrayList<>(i + 1); // Nueva fila de tamaño dinámico

            currentRow.add(1); // Primer elemento siempre es 1

            // Construir los elementos intermedios usando solo la fila anterior
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1); // Último elemento siempre es 1

            result.add(currentRow); // Agregar la nueva fila al resultado
        }

        return result;
    }
}
