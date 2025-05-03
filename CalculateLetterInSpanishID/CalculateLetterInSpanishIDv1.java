package CalculateLetterInSpanishID;

import java.util.Scanner;

public class CalculateLetterInSpanishIDv1 {
    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);
        try{
            System.out.print("Input: ");
            int input = kbd.nextInt();
            System.out.println("Output: " + calculateLetterInSpanish(input));
        } catch(Exception e) {
            System.out.println("Invalid input. Please enter an 8-digit number.");
        }
        kbd.close();
    }

    public static String calculateLetterInSpanish(int n){
        if (String.valueOf(n).length() != 8) {
            throw new IllegalArgumentException("Input must be an 8-digit number.");
        }
        int remainder = n % 23;
        String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
        return n + "" + letters.charAt(remainder);
    }
}
