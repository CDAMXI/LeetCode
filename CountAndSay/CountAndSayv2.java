package CountAndSay;

public class CountAndSayv2 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if (n < 1 || n > 30) {
            return "NAN (not an answer)";
        }
        if (n == 1) {
            return "1";
        }
        String result = "1"; // Initialize the first term
    
        for (int i = 2; i <= n; i++) { // Iterate from 2 to n
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);
    
            // Go through the string to count the consecutive digits
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++; // Increment the count if the digit is the same
                } else {
                    current.append(count).append(prev); // Add the count and the digit to the result
                    count = 1; // Restart the counter
                    prev = result.charAt(j); // Update the current character
                }
            }
    
            // Add the last group to result
            current.append(count).append(prev);
    
            result = current.toString(); // Updated the result
        }
    
        return result;
    }
    
}
