package AddBinary;

public class addBinaryv1 {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }

    public static String addBinary(String a, String b){
        if (!a.matches("[01]+") && !b.matches("[01]+")) {return "At least one of the numbers is not in binary";}

        int a2 = Integer.parseInt(a,2);
        int b2 = Integer.parseInt(b,2);
        int result = a2 + b2;
        String r = Integer.toBinaryString(result);
        return r;
    }
}
