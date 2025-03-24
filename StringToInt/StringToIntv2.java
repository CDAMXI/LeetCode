package StringToInt;

import java.util.HashMap;
import java.util.Map;

public class StringToIntv2 {
    private static final Map<String, Integer> WORD_TO_NUMBER = new HashMap<>();
    
    static {
        // Ones
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
        
        // Teens (10-19)
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
        
        // Tens (20-90)
        WORD_TO_NUMBER.put("Twenty", 20);
        WORD_TO_NUMBER.put("Thirty", 30);
        WORD_TO_NUMBER.put("Forty", 40);
        WORD_TO_NUMBER.put("Fifty", 50);
        WORD_TO_NUMBER.put("Sixty", 60);
        WORD_TO_NUMBER.put("Seventy", 70);
        WORD_TO_NUMBER.put("Eighty", 80);
        WORD_TO_NUMBER.put("Ninety", 90);
        
        // Hundreds
        WORD_TO_NUMBER.put("One Hundred", 100);
        WORD_TO_NUMBER.put("Two Hundred", 200);
        WORD_TO_NUMBER.put("Three Hundred", 300);
        WORD_TO_NUMBER.put("Four Hundred", 400);
        WORD_TO_NUMBER.put("Five Hundred", 500);
        WORD_TO_NUMBER.put("Six Hundred", 600);
        WORD_TO_NUMBER.put("Seven Hundred", 700);
        WORD_TO_NUMBER.put("Eight Hundred", 800);
        WORD_TO_NUMBER.put("Nine Hundred", 900);
        
        // Thousands
        WORD_TO_NUMBER.put("One Thousand", 1000);
        WORD_TO_NUMBER.put("Two Thousand", 2000);
        WORD_TO_NUMBER.put("Three Thousand", 3000);
        WORD_TO_NUMBER.put("Four Thousand", 4000);
        WORD_TO_NUMBER.put("Five Thousand", 5000);
        WORD_TO_NUMBER.put("Six Thousand", 6000);
        WORD_TO_NUMBER.put("Seven Thousand", 7000);
        WORD_TO_NUMBER.put("Eight Thousand", 8000);
        WORD_TO_NUMBER.put("Nine Thousand", 9000);
        
        // Miillones
        WORD_TO_NUMBER.put("One Million", 1_000_000);
        WORD_TO_NUMBER.put("Two Million", 2_000_000);
        WORD_TO_NUMBER.put("Three Million", 3_000_000);
        WORD_TO_NUMBER.put("Four Million", 4_000_000);
        WORD_TO_NUMBER.put("Five Million", 5_000_000);
        WORD_TO_NUMBER.put("Six Million", 6_000_000);
        WORD_TO_NUMBER.put("Seven Million", 7_000_000);
        WORD_TO_NUMBER.put("Eight Million", 8_000_000);
        WORD_TO_NUMBER.put("Nine Million", 9_000_000);
        
        // Billones
        WORD_TO_NUMBER.put("One Billion", 1_000_000_000);
        WORD_TO_NUMBER.put("Two Billion", 2_000_000_000);
    }

    public static void main(String[] args) {
        System.out.println(stringToInt("Zero"));       // 0
        System.out.println(stringToInt("Twenty Five")); // 25
        System.out.println(stringToInt("One Hundred Twenty Three")); // 123
        System.out.println(stringToInt("One Thousand Five Hundred")); // 1500
    }

    public static int stringToInt(String str) {
        String[] words = str.split(" ");
        int total = 0;
        int current = 0;
        
        for (String word : words) {
            Integer value = WORD_TO_NUMBER.get(word);
            if (value == null) {
                // If the word is not in the map, it could be a composite number
                // We would need additional logic to handle cases like "Twenty Five
                return -1; // Indicate error or not implemented
            }
            
            if (value >= 100) {
                current *= value;
                if (value >= 1000) {
                    total += current;
                    current = 0;
                }
            } else {
                current += value;
            }
        }
        
        total += current;
        return total;
    }
}
