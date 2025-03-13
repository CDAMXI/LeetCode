import java.util.*;

public class IntToStringv2 {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int num = 0;
        boolean isNumber = false;
        do {
            try {
                System.out.print("Enter a number: ");
                num = Integer.parseInt(kbd.nextLine());
                System.out.println("Result: " + numbersToWords(num));
                isNumber = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        } while (!isNumber);
        
        kbd.close();
    }

    public static String numbersToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();
        convertChunk(num, result);
        return result.toString().trim();
    }

    private static void convertChunk(int num, StringBuilder result) {
        try {
            if (num < 0) {
                result.append("Negative ");
                num *= -1;
                
            }
            if (num >= 1_000_000_000) {
                convertChunk(num / 1_000_000_000, result);
                result.append("Billion ");
                num %= 1_000_000_000;
            }
            if (num >= 1_000_000) {
                convertChunk(num / 1_000_000, result);
                result.append("Million ");
                num %= 1_000_000;
            }
            if (num >= 1000) {
                convertChunk(num / 1000, result);
                result.append("Thousand ");
                num %= 1000;
            }
            if (num >= 100) {
                result.append(units[num / 100]).append(" Hundred ");
                num %= 100;
            }
            if (num >= 20) {
                result.append(tens[num / 10]).append(" ");
                num %= 10;
            }
            if (num >= 10) {
                result.append(teens[num - 10]).append(" ");
            } else if (num > 0) {
                result.append(units[num]).append(" ");
            }
        } catch (Exception e) {
            result.append("Number out of range");
        }
    }
}
