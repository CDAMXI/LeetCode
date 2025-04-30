package SelfDividingNumbers;

import java.util.*;

public class SelfDividingNumbersv3 {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));  // [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        System.out.println(selfDividingNumbers(47, 85)); // [48, 55, 66, 77]
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>((right-left)/2); // Capacidad inicial optimizada
        
        for (int i = left; i <= right; i++) {
            if (isSelfDividingUltra(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private static boolean isSelfDividingUltra(int num) {
        int n = num;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0 || (num % digit) != 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
