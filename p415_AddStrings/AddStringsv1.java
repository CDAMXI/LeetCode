package p415_AddStrings;

public class AddStringsv1 {
    public static void main(String[] args){
        String num1 = "11", num2 = "123";
        System.out.println(num1 + " + " + num2 + " = " + addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2){
        int n = Integer.parseInt(num1), m = Integer.parseInt(num2);
        int sum = n + m;
        return sum + "";
    }
}
