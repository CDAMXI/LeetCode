package PascalsTriangleII;

import java.util.*;

public class PascalsTriangleIIv1 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter the number of rows desired for Pascal's Triangle: ");
                int rows = kbd.nextInt();
                
                if (rows <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Ask for a valid value again
                }

                List<Integer> pascalTriangle = getRow(rows);
                for (int row : pascalTriangle) {
                    System.out.println(row);
                }

                isValid = true; // A valid value is entered, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consume the invalid token
            }
        }

        kbd.close(); // Close the scanner at the end
    }
    
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>(); // Main list

        if (rowIndex <= 0) {return result.get(0);} // If there are no rows, return an empty list

        // First row is always [1]
        result.add(new ArrayList<>(List.of(1)));

        // Build rows from the second to rowIndex
        for (int i = 1; i < rowIndex; i++) {
            List<Integer> prevRow = result.get(i - 1); // Previous row
            List<Integer> currentRow = new ArrayList<>(i + 1); // New row with dynamic size

            currentRow.add(1); // First element is always 1

            // Build the intermediate elements using only the previous row
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            currentRow.add(1); // Last element is always 1

            result.add(currentRow); // Add the new row to the result
        }

        return result.get(rowIndex - 1); // Return the requested row
    }
}
