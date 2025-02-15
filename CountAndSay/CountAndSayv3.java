package CountAndSay;

public class CountAndSayv3 {
    public static void main(String[] args) {
        System.out.println(countAndSay(1)); // Output: "1"
        System.out.println(countAndSay(2)); // Output: "11"
        System.out.println(countAndSay(3)); // Output: "21"
        System.out.println(countAndSay(4)); // Output: "1211"
        System.out.println(countAndSay(5)); // Output: "111221"
        System.out.println(countAndSay(10)); // Output: "13211311123113112211"
    }

    public static String countAndSay(int n) {
        if (n < 1 || n > 30) {
            return "NAN (not an answer)";
        }
        if (n == 1) {
            return "1";
        }
    
        StringBuilder result = new StringBuilder("1");
    
        for (int i = 2; i <= n; i++) {
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);
    
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++;
                } else {
                    current.append(count).append(prev);
                    count = 1;
                    prev = result.charAt(j);
                }
            }
    
            current.append(count).append(prev);
            result = current; // Reutilizamos `result` para evitar crear nuevas cadenas
        }
    
        return result.toString();
    }
}