package p415_AddStrings;

public class AddStringv3 {
    public static void main(String[] args){
        String num1 = "11", num2 = "123";
        System.out.println(num1 + " + " + num2 + " = " + addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder resultado = new StringBuilder();
        
        // Empezamos desde el último dígito de ambas cadenas
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int acarreo = 0;

        // Continuamos mientras haya dígitos por sumar o quede un acarreo
        while (i >= 0 || j >= 0 || acarreo > 0) {
            // Obtenemos el dígito actual (o 0 si ya terminamos con esa cadena)
            int digito1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digito2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            // Sumamos los dígitos y el acarreo de la operación anterior
            int suma = digito1 + digito2 + acarreo;

            // Añadimos el último dígito de la suma al resultado (ej. si es 14, añadimos 4)
            resultado.append(suma % 10);
            
            // Calculamos el nuevo acarreo (ej. si es 14, el acarreo es 1)
            acarreo = suma / 10;

            // Movemos los punteros
            i--;
            j--;
        }

        // Como construimos el resultado de atrás hacia adelante, hay que invertirlo
        return resultado.reverse().toString();
    }
}
