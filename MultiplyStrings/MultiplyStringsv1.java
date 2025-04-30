public class MultiplyStringsv1{
    public static void main(String[] args) {
        System.out.println(multiply("123", "456")); // Output: 56088
        System.out.println(multiply("0", "456")); // Output: 0
    }

    public static String multiply(String num1, String num2){
        int cont1 = 0, cont2 = 0;
        if (num1.length() == 0 || num2.length() == 0 ||
        num1.equals("0") || num2.equals("0")){
            return "0";
        }
        for (int i = 0; i < num1.length(); i++){
            cont1 = cont1 * 10 + (num1.charAt(i) - '0');
        }
        for (int i = 0; i < num2.length(); i++){
            cont2 = cont2 * 10 + (num2.charAt(i) - '0');
        }
        return String.valueOf(cont1 * cont2);
    }
}
