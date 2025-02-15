package NumbersOfOnes;

public class NumbersOfOnesv2 {
    public static void main(String[] args) {
        System.out.println(countDigitOne(13)); // Output: 6
        System.out.println(countDigitOne(824883294)); // Output: 767944060
    }

    public static int countDigitOne(int n) {
        int count = 0;
        long factor = 1; // Representa las posiciones (1, 10, 100, ...)
        
        while (factor <= n) {
            long lower = n % factor; // Parte derecha del número
            long current = (n / factor) % 10; // Dígito actual
            long higher = n / (factor * 10); // Parte izquierda del número
            
            if (current == 0) {
                count += higher * factor;
            } else if (current == 1) {
                count += higher * factor + lower + 1;
            } else {
                count += (higher + 1) * factor;
            }

            factor *= 10; // Pasamos a la siguiente posición decimal
        }

        return count;
    }
}
