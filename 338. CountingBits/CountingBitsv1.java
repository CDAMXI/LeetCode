package CountingBits;

public class CountingBitsv1 {
    public static void main(String[] args){
        System.out.println("Input: 5");
        System.out.print("Output: [");
        int[] result = countBits(5);
        for (int i = 0; i < result.length; i++) {
            if (i != result.length - 1) {
                System.out.print(result[i] + ", ");
            } else {
                System.out.print(result[i]);
            }
        }
        System.out.println("]");
    }

    public static int[] countBits(int n){
        int[] result = new int[n + 1];
        for (int i = 0; i < result.length; i++) {
            if (i <= 1) {result[i] = i;}
            int countOnes = 0;
            String binaryString = toBinaryString(i);
            for (int j = 0; j < binaryString.length(); j++) {
                if (binaryString.charAt(j) == '1') {countOnes++;}
            }
            result[i] = countOnes;
        }
        return result;
    }

    private static String toBinaryString(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
