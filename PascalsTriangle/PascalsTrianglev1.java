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
                    continue; // Ask for a valid value again
                }

                List<List<Integer>> pascalTriangle = generate(rows);
                for (List<Integer> row : pascalTriangle) {
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

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(); // Main list
    
        if (numRows <= 0) {return result;} // If there are no rows, return an empty list
    
        // The first row of Pascal's Triangle is always [1]
        result.add(new ArrayList<>(List.of(1)));
    
        // Build rows from the second to numRows
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = result.get(i - 1); // Previous row
            List<Integer> currentRow = new ArrayList<>();
    
            // First element of each row is 1
            currentRow.add(1);
    
            // Build the intermediate elements
            for (int j = 1; j < prevRow.size(); j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
    
            // Last element of each row is 1
            currentRow.add(1);
    
            // Add the current row to the result
            result.add(currentRow);
        }
    
        return result;
    }
}
