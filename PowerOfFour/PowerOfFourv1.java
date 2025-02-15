package PowerOfFour;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerOfFourv1 {
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

    public static boolean isPowerOfFour(int n){
        if (n == 1) {return true;}
        if(n < 1){return false;}
        return Math.log(n)/Math.log(4) == Math.floor(Math.log(n)/Math.log(4));
    }
}
