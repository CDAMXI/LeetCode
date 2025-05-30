import java.math.BigInteger;
import java.util.Scanner;

public class NthFibNumv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Fibonacci Sequence Calculator");
        System.out.println("Type 'exit' to quit the program.\n");

        while (true) {
            System.out.print("Enter the position of the Fibonacci sequence: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }

            try {
                int n = Integer.parseInt(input);
                if (n < 0) {
                    System.out.println("Please enter a non-negative integer.");
                    continue;
                }

                BigInteger fibValue = nthFibNum(n);
                System.out.println("The " + n + "th value of the Fibonacci sequence is: " + fibValue + "\n");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.\n");
            }
        }

        scanner.close();
    }

    // Uses BigInteger to handle large Fibonacci numbers
    public static BigInteger nthFibNum(int n) {
        if (n == 0) return BigInteger.ZERO;
        if (n == 1) return BigInteger.ONE;

        BigInteger prev = BigInteger.ZERO;
        BigInteger curr = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
            BigInteger next = prev.add(curr);
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
