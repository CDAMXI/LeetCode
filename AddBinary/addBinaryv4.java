package AddBinary;

import java.math.*;
import java.util.*;

public class addBinaryv4 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String a,b;
        do {
            System.out.print("Introduce the first value: ");
            a = kbd.next();
        } while (!a.chars().allMatch(Character::isDigit)); //Se están usando expresiones lambda

        do {
            System.out.print("Introduce the second value: ");
            b = kbd.next();
        } while (!b.chars().allMatch(Character::isDigit)); //Se están usando expresiones lambda
        
        
        System.out.println("El resultado en binario es: " + addBinary(a, b));
        kbd.close();
    }

    public static String addBinary(String a, String b){
        // Validar que solo contengan ceros y unos
        if (!a.matches("[01]+") || !b.matches("[01]+")) {return "At least one of the numbers is not in binary";}

        // Sumar los valores
        BigInteger result = new BigInteger(a, 2).add(new BigInteger(b, 2));
        //Al crear el BigInteger, el 2 que se pasa por parámetros, va a transformar el valor b a binario

        // Convertir el resultado de vuelta a binario
        return result.toString(2);
        // Pasa result a un string formado por chars correspondientes a valores binarios
    }

    public static String convertToBinary(String a){
        BigInteger bi = new BigInteger(a);
        return bi.toString(2);
    }
}
