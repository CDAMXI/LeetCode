package PascalsTriangleII;

import java.util.*;

public class PascalsTriangleIIv2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int rows = -1;

        while (rows < 0) {
            try {
                System.out.print("Enter the row index for Pascal's Triangle: ");
                rows = kbd.nextInt();

                if (rows < 0) {
                    System.out.println("Please enter a non-negative integer.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a non-negative integer.");
                kbd.next(); // Consumir el token inválido
            }
        }

        kbd.close();

        // Obtener la fila deseada
        List<Integer> pascalRow = getRow(rows);
        System.out.println(pascalRow);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // Primera posición siempre es 1

        // Construcción de la fila con una única lista
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i)); // Fórmula combinatoria
        }

        return row;
    }
}
