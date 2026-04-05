package p13_RomanToInteger;

import java.util.*;

public class RomanToIntegerv2 {
    // Static map to store the values of Roman numbers
    private static final Map<Character, Integer> ROMAN_VALUES = Map.of(
            'I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static void main(String[] args) {
        System.out.println(romanToInt("III")); // 3
        System.out.println(romanToInt("LVIII")); // 58
        System.out.println(romanToInt("MCMXCIV")); // 1994
        try (Scanner kbd = new Scanner(System.in)) {
            String num = kbd.nextLine();
            System.out.println(num);
        }
    }

    public static int romanToInt(String s) {
        int num = 0;

        // Iterating over the string from left to right
        for (int i = 0; i < s.length(); i++) {
            Integer current = ROMAN_VALUES.get(s.charAt(i));
            Integer next = (i < s.length() - 1) ? ROMAN_VALUES.get(s.charAt(i + 1)) : null;
            //

            // If the current value is less than the next, we subtract it; otherwise, we add
            // it
            if (next != null && current < next) {
                num -= current;
            } else {
                num += current;
            }
        }

        return num;
    }
}
