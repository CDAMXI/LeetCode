public class MultiplyStringsv2 {
    public static void main(String[] args) {
        System.out.println(multiply("123", "456")); // Output: 56088
        System.out.println(multiply("0", "456"));   // Output: 0
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n];

        // Recorremos desde el final de ambas cadenas
        for (int i = m - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int sum = digit1 * digit2 + result[i + j + 1];

                result[i + j + 1] = sum % 10;                // Colocar la unidad
                result[i + j] += sum / 10;                   // Añadir la decena al siguiente
            }
        }

        // Convertir el array a String (omitimos ceros a la izquierda)
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }

        return sb.toString();
    }
}
