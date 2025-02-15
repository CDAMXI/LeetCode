package AddBinary;

import java.math.*;

public class addBinaryv3 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b){
        // Validar que solo contengan ceros y unos
        if (!a.matches("[01]+") || !b.matches("[01]+")) {return "At least one of the numbers is not in binary";}

        // Convertir de binario a BigInteger
        BigInteger a2 = new BigInteger(a, 2);
        BigInteger b2 = new BigInteger(b, 2);

        // Sumar los valores
        BigInteger result = a2.add(b2);

        // Convertir el resultado de vuelta a binario
        return result.toString(2); // Base 2 para representación binaria
    }
}
