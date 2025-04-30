package SelfDividingNumbers;

import java.util.*;

public class SelfDividingNumbersv2 {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22)); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
        System.out.println(selfDividingNumbers(47, 85)); // [48, 55, 66, 77]
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (isSelfDividingOptimized(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean isSelfDividingOptimized(int num) {
        String s = Integer.toString(num);
        
        // Si el número contiene '0', descartarlo inmediatamente
        if (s.contains("0")) {
            return false;
        }

        for (char c : s.toCharArray()) {
            int digit = c - '0';
            if (num % digit != 0) {
                return false;
            }
        }

        return true;
    }
}
