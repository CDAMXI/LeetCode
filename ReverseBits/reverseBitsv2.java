public class reverseBitsv2 {
    public static void main(String[] args) {
        //Exceptions are thrown because when converting 43261596 to binary, the value exceeds the limits of an int
        //System.out.println(reverseBits(Integer.parseInt(Integer.toBinaryString(43261596))));
        //System.out.println(reverseBits(Integer.parseInt(Integer.toBinaryString(-3))));
    }

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) { // Process the 32 bits of `n`
            result <<= 1;             // Move `result` to the left
            result |= (n & 1);        // Add the least significant bit of `n` to `result`
            n >>>= 1;                 // Move `n` to the right (unsigned)
        }
        return result;
    }
    
}
