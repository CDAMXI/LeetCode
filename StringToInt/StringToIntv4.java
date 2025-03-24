package StringToInt;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashMap;
import java.util.Map;
import java.util.Locale;

public class StringToIntv4 {
    private static final Map<String, Integer> WORD_TO_NUMBER = new HashMap<>();
    private static final Map<String, Integer> MULTIPLIERS = new HashMap<>();
    
    static {
        // Basic numbers
        WORD_TO_NUMBER.put("Zero", 0);
        WORD_TO_NUMBER.put("One", 1);
        WORD_TO_NUMBER.put("Two", 2);
        WORD_TO_NUMBER.put("Three", 3);
        WORD_TO_NUMBER.put("Four", 4);
        WORD_TO_NUMBER.put("Five", 5);
        WORD_TO_NUMBER.put("Six", 6);
        WORD_TO_NUMBER.put("Seven", 7);
        WORD_TO_NUMBER.put("Eight", 8);
        WORD_TO_NUMBER.put("Nine", 9);
        WORD_TO_NUMBER.put("Ten", 10);
        WORD_TO_NUMBER.put("Eleven", 11);
        WORD_TO_NUMBER.put("Twelve", 12);
        WORD_TO_NUMBER.put("Thirteen", 13);
        WORD_TO_NUMBER.put("Fourteen", 14);
        WORD_TO_NUMBER.put("Fifteen", 15);
        WORD_TO_NUMBER.put("Sixteen", 16);
        WORD_TO_NUMBER.put("Seventeen", 17);
        WORD_TO_NUMBER.put("Eighteen", 18);
        WORD_TO_NUMBER.put("Nineteen", 19);
        
        // Tens
        WORD_TO_NUMBER.put("Twenty", 20);
        WORD_TO_NUMBER.put("Thirty", 30);
        WORD_TO_NUMBER.put("Forty", 40);
        WORD_TO_NUMBER.put("Fifty", 50);
        WORD_TO_NUMBER.put("Sixty", 60);
        WORD_TO_NUMBER.put("Seventy", 70);
        WORD_TO_NUMBER.put("Eighty", 80);
        WORD_TO_NUMBER.put("Ninety", 90);
        
        // Multipliers
        MULTIPLIERS.put("Hundred", 100);
        MULTIPLIERS.put("Thousand", 1000);
        MULTIPLIERS.put("Million", 1_000_000);
        MULTIPLIERS.put("Billion", 1_000_000_000);
    }

    public static void main(String[] args) {
        System.out.println(formatNumber(stringToInt("Zero")));                       // 0
        System.out.println(formatNumber(stringToInt("Twenty Five")));                // 25
        System.out.println(formatNumber(stringToInt("One Hundred Twenty Three")));   // 123
        System.out.println(formatNumber(stringToInt("One Thousand Five Hundred")));  // 1 500
        System.out.println(formatNumber(stringToInt("Two Hundred Fifty Six")));      // 256
        System.out.println(formatNumber(stringToInt("One Million Two Hundred Thousand"))); // 1 200 000
        System.out.println(formatNumber(stringToInt("Two Thousand Thirty Five")));   // 2 035
    }

    public static int stringToInt(String str) {
        String[] words = str.split(" ");
        int total = 0;
        int current = 0;
        
        for (String word : words) {
            if (WORD_TO_NUMBER.containsKey(word)) {
                current += WORD_TO_NUMBER.get(word);
            } 
            else if (MULTIPLIERS.containsKey(word)) {
                int multiplier = MULTIPLIERS.get(word);
                if (word.equals("Hundred")) {
                    current *= multiplier;
                } 
                else {
                    total += current * multiplier;
                    current = 0;
                }
            }
        }
        
        total += current;
        return total;
    }

    public static String formatNumber(int number) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator(' ');
        DecimalFormat formatter = new DecimalFormat("#,###", symbols);
        formatter.setGroupingSize(3);
        return formatter.format(number).replace(",", " ");
    }
}
