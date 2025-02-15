import java.util.Arrays;

public class plusOnev5 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusone(new int[]{1, 2, 3}))); // [1, 2, 4]
        System.out.println(Arrays.toString(plusone(new int[]{4, 3, 2, 1}))); // [4, 3, 2, 2]
        System.out.println(Arrays.toString(plusone(new int[]{9}))); // [1, 0]
        System.out.println(Arrays.toString(plusone(new int[]{1,9}))); // [2, 0]
        System.out.println(Arrays.toString(plusone(new int[]{9,9}))); // [1, 0, 0]
        System.out.println(Arrays.toString(plusone(new int[]{9,0}))); // [9, 1]
    }

    public static int[] plusone(int[] digits) {
        // Iterar desde el último dígito hacia el primero
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // Retorna directamente si no hay acarreo
            }
            digits[i] = 0; // Si el dígito es 9, lo establece en 0 y sigue el bucle
        }

        // Si todos los dígitos son 9, necesitamos un array más grande
        int[] result = new int[digits.length + 1];
        result[0] = 1; // El primer dígito será 1, los demás ya son 0
        return result;
    }
}
