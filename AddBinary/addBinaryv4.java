package addBinary;

import java.math.*;
import java.util.*;

public class addBinaryv4 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        String a,b;
        do {
            System.out.print("Introduce el primer valor: ");
            a = kbd.next();
        } while (!a.chars().allMatch(Character::isDigit)); //Se están usando expresiones lambda

        do {
            System.out.print("Introduce el segundo valor: ");
            b = kbd.next();
        } while (!b.chars().allMatch(Character::isDigit)); //Se están usando expresiones lambda
        
        
        System.out.println("El resultado en binario es: " + addBinary(a, b));
        kbd.close();
    }

    public static String addBinary(String a, String b){
        // Validar que solo contengan ceros y unos
        if (!a.matches("[01]+")) {
            a = convertToBinary(a);
        }

        if(!b.matches("[01]+")){
            b = convertToBinary(b);
        }

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
