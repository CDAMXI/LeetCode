package ClosestPrimeInRange;

public class ClosestPrimeInRangev2 {
    public static void main(String[] args) {
        printArray(closestPrime(10, 20));  // Output: [11, 13]
        printArray(closestPrime(1, 10));   // Output: [2, 3]
        printArray(closestPrime(3, 10));   // Output: [3, 3]
        printArray(closestPrime(4, 6));   // Output: [-1,-1]
    }

    public static int[] closestPrime(int left, int right) {
        // Step 1: Generate all primes in the range [left, right] using the Sieve of Eratosthenes
        boolean[] isPrime = sieveOfEratosthenes(right);

        //  Step 2: Find the closest pair of primes
        int[] result = new int[2];
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

        // If no pair is found, return the same prime twice
        if (result[0] == 0 && result[1] == 0 && prevPrime != -1) {
            result[0] = prevPrime;
            result[1] = prevPrime;
        }

        return result;
    }

    // Sieve of Eratosthenes to mark prime numbers up to a limit
    public static boolean[] sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= limit; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= limit; j += i) {
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
