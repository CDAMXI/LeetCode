public class numberOf1Bitsv1 {
    public static void main(String[] args){
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
        System.out.println(hammingWeight(2147483645));
    }

    public static int hammingWeight(int n){
        int cont = 0;
        String value = Integer.toBinaryString(n);
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1') {cont++;}
        }
        return cont;
    }
}
