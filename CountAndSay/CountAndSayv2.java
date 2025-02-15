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
        String result = "1"; // Inicializamos el primer término
    
        for (int i = 2; i <= n; i++) { // Iteramos desde 2 hasta n
            StringBuilder current = new StringBuilder();
            int count = 1;
            char prev = result.charAt(0);
    
            // Recorremos la cadena para contar los dígitos consecutivos
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prev) {
                    count++; // Incrementamos el contador si el dígito es igual
                } else {
                    current.append(count).append(prev); // Añadimos el conteo y el dígito al resultado
                    count = 1; // Reiniciamos el contador
                    prev = result.charAt(j); // Actualizamos el carácter actual
                }
            }
    
            // Añadimos el último grupo al resultado
            current.append(count).append(prev);
    
            result = current.toString(); // Actualizamos el resultado
        }
    
        return result;
    }
    
}
