package ClosestPrimeInRange;

public class ClosestPrimeInRangev3 {
    public static void main(String[] args) {
        printArray(closestPrime(10, 20));  // Output: [11, 13]
        printArray(closestPrime(1, 10));   // Output: [2, 3]
        printArray(closestPrime(3, 10));   // Output: [3, 3]
        printArray(closestPrime(4, 6));    // Output: [-1, -1]
    }

    public static int[] closestPrime(int left, int right) {
        // Step 1: Generate all primes in the range [left, right] using the Sieve of Eratosthenes
        boolean[] isPrime = sieveOfEratosthenes(right);

        // Step 2: Find the closest pair of primes
        int[] result = {-1, -1}; // Default result if no primes are found
        int minDiff = Integer.MAX_VALUE;
        int prevPrime = -1;

        for (int i = left; i <= right; i++) {
            if (isPrime[i]) {
                if (prevPrime != -1) {
                    int diff = i - prevPrime;
                    if (diff < minDiff) {
                        minDiff = diff;
                        result[0] = prevPrime;
                        result[1] = i;
                    }
                }
                prevPrime = i;
            }
        }

        // If no pair of primes is found, return [-1, -1]
        if (result[0] == -1) {
            return result;
        }

        return result;
    }

    // Sieve of Eratosthenes to mark prime numbers up to a limit
    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        if (limit >= 2) {
            isPrime[2] = true;
        }
        for (int i = 3; i <= limit; i += 2) {
            isPrime[i] = true;
        }

        for (int i = 3; i * i <= limit; i += 2) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += 2 * i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    // Method to print the array
    public static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
