public class divideTwoIntegersv2 {
    public static void main(String[] args) {
        System.out.println(divide(10, 3));    // 3
        System.out.println(divide(7, -3));   // -2
    }

    public static int divide(int dividend, int divisor) {
        // Manejo de caso especial de divisor igual a 0
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        
        // Manejo de caso especial de desbordamiento
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Evitar desbordamiento
        }

        // Determinar el signo del resultado
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Trabajar con valores absolutos
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        // Inicializar el cociente
        int result = 0;

        // Realizar la división usando restas y desplazamientos binarios
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Incrementar el divisor usando desplazamientos binarios
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Restar el mayor múltiplo del divisor posible
            absDividend -= tempDivisor;
            result += multiple;
        }

        // Devolver el resultado con el signo correcto
        return isNegative ? -result : result;
    }
}
