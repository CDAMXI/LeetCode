package Fibonacci;

public class Fibonacciv1 {
    public static void main(String[] args) {
        System.out.println(fib(2)); // Example usage
        System.out.println(fib(3)); // Example usage
        System.out.println(fib(4)); // Example usage
    }

    public static int fib(int n){
        if (n <= 1) return n; // Base case: if n is 0 or 1, return n
        return fib(n - 1) + fib(n - 2); // Recursive case: sum of the two preceding numbers
    }
}
