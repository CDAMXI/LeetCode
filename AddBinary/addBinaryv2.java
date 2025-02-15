package AddBinary;

public class addBinaryv2 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b){
        if (!a.matches("[01]+") && !b.matches("[01]+")) {return "At least one of the numbers is not in binary";}

        long a2 = Long.parseLong(a,2);
        long b2 = Long.parseLong(b,2);
        long result = a2 + b2;
        String r = Long.toBinaryString(result);
        return r;
    }
}
