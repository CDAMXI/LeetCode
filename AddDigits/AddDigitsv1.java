package AddDigits;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddDigitsv1 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print("Enter a number to see the sum of it's digits: ");
                int num = kbd.nextInt();

                System.out.println("If you add all the digits in " + num + " you get: " + addDigits(num));

                isValid = true; // Se introduce un valor válido, salir del ciclo
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
                kbd.next(); // Consumir el token inválido
            }
        }
        kbd.close();
    }

    public static int addDigits(int num){
        if(num < 0){num = -num;}
        if (num < 10) {return num;}
        while (num > 9) {
            if(num < 0){num = -num;}
            if (num < 10) {return num%10;}
            num = (num%10)+addDigits(num/10);
        }
        return num;
    }
}
