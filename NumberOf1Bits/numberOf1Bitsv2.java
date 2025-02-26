public class numberOf1Bitsv2 {
    public static void main(String[] args){
        System.out.println(hammingWeight(11));          // Output: 3
        System.out.println(hammingWeight(128));        // Output: 1
        System.out.println(hammingWeight(2147483645)); // Output: 30
    }

    public static int hammingWeight(int n){
        int count = 0;
        while (n != 0) {
            count += (n & 1); // Increment if the least significant bit is 1
            n >>>= 1;        // Shift bits to the right without sign extension
        }
        return count;
    }
}
