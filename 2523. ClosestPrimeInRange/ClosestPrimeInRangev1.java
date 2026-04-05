package ClosestPrimeInRange;

public class ClosestPrimeInRangev1 {
    public static void main(String[] args) {
        printArray(closestPrime(10, 20));  // Output: [11, 13]
        printArray(closestPrime(1, 10));   // Output: [2, 3]
        printArray(closestPrime(3, 10));   // Output: [3, 3]
    }

    public static int[] closestPrime(int left, int right){
        int[] result = new int[2];
        int minDiff = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {
                for (int j = i + 1; j <= right; j++) {
                    if (isPrime(j)) {
                        int diff = j - i;
                        if (diff < minDiff) {
                            minDiff = diff;
                            result[0] = i;
                            result[1] = j;
                        }
                    }
                }
            }
        }

        return result;
    }

    public static boolean isPrime(int n){
        int cont = 0;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == n / i) {cont++;}
                else{cont+=2;}
            }
        }
        return cont == 2;
    }

    public static void printArray(int[] arr){
        System.out.print("[");
        for (int i : arr) {
            if (i == arr[arr.length - 1]) {
                System.out.print(i);
                break;
            }
            else{System.out.print(i + ", ");}
        }
        System.out.print("]");
        System.out.println();
    }
}
