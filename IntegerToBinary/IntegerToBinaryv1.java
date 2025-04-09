import java.util.*;

public class IntegerToBinaryv1{
    public static void main(String[] args){
        Scanner kbd = new Scanner(System.in);
        int n = 0;

        do{
            System.out.print("Enter a positive integer (negative number to quit): ");
            n = kbd.nextInt();
            if(n > 0){
                System.out.println("The binary representation of " + n + " is: " + Integer.toBinaryString(n));
            } else if(n < 0){
                System.out.println("Please enter a positive integer.");
            }
        } while(!(n < 0));
        kbd.close();
    }
}
