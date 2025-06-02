import java.util.*;

public class CompareNamesv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input
        System.out.print("Enter the first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter the second name: ");
        String secondName = scanner.nextLine();

        // Comparing the names and showing the result
        System.out.println(compare(firstName, secondName));
        
        scanner.close();
    }

    /**
     * Compares two strings for equality, ignoring case.
     * If different, shows where the divergence starts.
     */
    public static String compare(String s1, String s2) {
        if (s1.equalsIgnoreCase(s2)) {
            return "Both names are the same";
        }

        String lowerS1 = s1.toLowerCase();
        String lowerS2 = s2.toLowerCase();

        int minLength = Math.min(lowerS1.length(), lowerS2.length());
        for (int i = 0; i < minLength; i++) {
            if (lowerS1.charAt(i) != lowerS2.charAt(i)) {
                return "Names are different [" + lowerS1.substring(i) + "],[" + lowerS2.substring(i) + "]";
            }
        }

        return "Names are different [" + lowerS1.substring(minLength) + "],[" + lowerS2.substring(minLength) + "]";
    }
}
