import java.util.HashMap;
import java.util.Map;

public class IntegerToRomanv1{
    public static void main(String[] args) {
        System.out.println("Result: " + intToRoman(3749));
        System.out.println("Result: " + intToRoman(58));
        System.out.println("Result: " + intToRoman(1));
    }

    public static String intToRoman(int num){
        Map<String, Integer> map = new HashMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);

        String result = "", numString = Integer.toString(num);
        while (numString.length() > 0){
            if (numString.charAt(0) - '0' > 0){
                int digit = numString.length() - 1;
                int value = (numString.charAt(0) - '0') * (int)Math.pow(10, digit);
                for (Map.Entry<String, Integer> entry : map.entrySet()){
                    if (value >= entry.getValue()){
                        result += entry.getKey();
                        numString = numString.substring(1);
                        break;
                    }
                }
            } else {
                numString = numString.substring(1);
                
            }
            
        }
        return result;
    }
}
