package PascalsTriangleII;

import java.util.*;

public class PascalsTriangleIIv2 {
    public static void main(String[] args) {
        int rows;
        try (Scanner kbd = new Scanner(System.in)) {
            rows = -1;
            while (rows < 0) {
                try {
                    System.out.print("Enter the row index for Pascal's Triangle: ");
                    rows = kbd.nextInt();
                    
                    if (rows < 0) {
                        System.out.println("Please enter a non-negative integer.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    kbd.next(); // Consume the invalid token
                }
            }
        }

        // Get the desired row
        List<Integer> pascalRow = getRow(rows);
        System.out.println(pascalRow);
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1); // First position is always 1

        // Build the row using a single list
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i)); // Combinatorial formula
        }

        return row;
    }
}
