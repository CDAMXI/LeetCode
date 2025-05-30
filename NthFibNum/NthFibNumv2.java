import java.util.Scanner;

public class NthFibNumv2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position (n) in the Fibonacci sequence: ");
        int n = scanner.nextInt();
        
        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            System.out.println("The " + n + "th value of the Fibonacci sequence is: " + getNthFibonacci(n));
        }
        
        scanner.close();
    }

    // Efficient iterative method to compute the n-th Fibonacci number
    public static long getNthFibonacci(int n) {
        if (n <= 1) return n;
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }
}
