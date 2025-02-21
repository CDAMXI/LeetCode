package UglyNumbers;

public class UglyNumbersv2 {
    public static void main(String[] args) {
        System.out.println(isUgly(6));   // true
        System.out.println(isUgly(8));   // true
        System.out.println(isUgly(1));   // true
        System.out.println(isUgly(14));  // false
    }

    public static boolean isUgly(int n) {
        if (n <= 0){return false;} // Los números <= 0 no son feos

        // Dividir n por 2, 3 y 5 hasta que ya no sea divisible por ellos
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        // Si después de eliminar los factores 2, 3 y 5 queda 1, es feo
        return n == 1;
    }
}
