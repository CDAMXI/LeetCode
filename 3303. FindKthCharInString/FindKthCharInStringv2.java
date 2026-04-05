package FindKthCharInString;

public class FindKthCharInStringv2 {

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));  // Output: b (k = 5)
    }

    public static char kthCharacter(int k) {
        int level = 0;
        int length = 1;

        // Find the level (how many time does the string double) until length >= k
        while (length < k) {
            length *= 2;
            level++;
        }

        // From the last level, simulate backwards
        return findChar(level, k, 'a');
    }

    // Recursive function that calculates the character at position k
    private static char findChar(int level, int k, char base) {
        if (level == 0) return base;

        int half = 1 << (level - 1); // Longitud of the left half

        if (k <= half) {
            return findChar(level - 1, k, base);
        } else {
            // Transformed char is the next in the alphabet
            char next = (char) ((base - 'a' + 1) % 26 + 'a');
            return findChar(level - 1, k - half, next);
        }
    }
}
