import java.util.*;

public class IntegerToBinaryv1{
    public static void main(String[] args) {
        int number = 0;
        Scanner kbd = new Scanner(System.in);
        do{
            System.out.print("Enter a non-negative integer (or a negative number to exit): " );
            String binaryString = Integer.toBinaryString(number);
            System.out.println("The binary representation of " + number + " is: " + binaryString);
        } while(number < 0);
        kbd.close();
    }
}
