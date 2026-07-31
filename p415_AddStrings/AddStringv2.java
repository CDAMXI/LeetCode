package p415_AddStrings;

public class AddStringv2 {
    public static void main(String[] args){
        String num1 = "11", num2 = "123";
        System.out.println(num1 + " + " + num2 + " = " + addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2){
        int n = 0, m = 0;

        for(int i = 0; i < num1.length(); i++){
            n*=10;
            n+=Integer.parseInt(num1.charAt(i) + "");
        }

        for(int i = 0; i < num2.length(); i++){
            m*=10;
            m+=Integer.parseInt(num2.charAt(i) + "");
        }

        return n + m + "";
    }
}
