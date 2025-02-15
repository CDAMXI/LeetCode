package PowOfThree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfThreev2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see if it´s a power of 3: ");
                int num = kbd.nextInt();
                
                if (num <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Pedir nuevamente un valor válido
                }

                if (isPowerOfThree(num)) {
                    System.out.println(num + " is indeed a power of three.");
                } else {
                    System.out.println(num + " is not a power of three.");
                }

                isValid = true; // Se introduce un valor válido, salir del ciclo
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consumir el token inválido
            }
        }
        kbd.close();
    }

    public static boolean isPowerOfThree(int n) {
        // Casos base: n debe ser mayor que 0 y debe ser divisible por 3 hasta que se convierta en 1
        if (n <= 0) {return false;}
    
        while (n % 3 == 0) {n /= 3;}
    
        return n == 1;
    }
    
}
