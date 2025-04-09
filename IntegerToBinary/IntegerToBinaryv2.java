import java.util.*;

public class IntegerToBinaryv2{
    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);
        int n = 0;

        do{
            try {
                System.out.print("Enter a positive integer (negative number to quit): ");
                n = kbd.nextInt();
                if(n > 0){
                    System.out.println("The binary representation of " + n + " is: " + Integer.toBinaryString(n));
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                kbd.next(); // Clear the invalid input
            }
        } while(!(n < 0));
        kbd.close();
    }
}
