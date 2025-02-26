import java.util.Arrays;

public class plusOnev5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusone(new int[]{1, 2, 3}))); // [1, 2, 4]
        System.out.println(Arrays.toString(plusone(new int[]{4, 3, 2, 1}))); // [4, 3, 2, 2]
        System.out.println(Arrays.toString(plusone(new int[]{9}))); // [1, 0]
        System.out.println(Arrays.toString(plusone(new int[]{1,9}))); // [2, 0]
        System.out.println(Arrays.toString(plusone(new int[]{9,9}))); // [1, 0, 0]
        System.out.println(Arrays.toString(plusone(new int[]{9,0}))); // [9, 1]
    }

    public static int[] plusone(int[] digits) {
        // Iterate from the last digit to the first
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // Return directly if there is no carry
            }
            digits[i] = 0; // If digits[i] is 9, set it to 0 and continue the loop
        }

        // If all digits are 9, we need a bigger array
        int[] result = new int[digits.length + 1];
        result[0] = 1; // The first digit will be 1, the others are already 0
        return result;
    }
}
