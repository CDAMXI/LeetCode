package PowerOfTwo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfTwov2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see if it´s a power of 2: ");
                int num = kbd.nextInt();
                
                if (num <= 0) {
                    System.out.println("Please enter a positive integer.");
                    continue; // Pedir nuevamente un valor válido
                }

                if (isPowerOfTwo(num)) {
                    System.out.println(num + " is indeed a power of two.");
                } else {
                    System.out.println(num + " is not a power of two.");
                }

                isValid = true; // Se introduce un valor válido, salir del ciclo
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consumir el token inválido
            }
        }
        kbd.close();
    }

    public static boolean isPowerOfTwo(int n){
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
