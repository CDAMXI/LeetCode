package PowerOfFour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfFourv2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see if it´s a power of 4: ");
                int num = kbd.nextInt();
                
                if (num <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Pedir nuevamente un valor válido
                }

                if (isPowerOfFour(num)) {
                    System.out.println(num + " is indeed a power of four.");
                } else {
                    System.out.println(num + " is not a power of four.");
                }

                isValid = true; // Se introduce un valor válido, salir del ciclo
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consumir el token inválido
            }
        }
        kbd.close();
    }

    public static boolean isPowerOfFour(int n) {
        // n debe ser mayor que 0 y debe ser divisible por 4 hasta que se convierta en 1
        if (n <= 0) {return false;}
    
        while (n % 4 == 0) {n /= 4;}
    
        return n == 1;
    }
    
}
