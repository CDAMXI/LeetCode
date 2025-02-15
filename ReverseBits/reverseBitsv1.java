public class reverseBitsv1 {
    public static void main(String[] args) {
        System.out.println(reverseBits(1011));
    }

    public static int reverseBits(int n){
        int result = 0;
        while (n >= 0) {
            result = result *= 10 + n % 10;
            n/=10;
        }
        result = Integer.parseInt(String.valueOf(result),2);
        return result;
    }
}
