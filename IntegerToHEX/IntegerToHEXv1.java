public class IntegerToHEXv1{
    public static void main(String[] args) {
        System.out.println("26 in hex is : " + toHex(26));
        System.out.println("255 in hex is : " + toHex(255));
    }

    public static String toHex(int num){
        return Integer.toHexString(num);
    }

    
}
