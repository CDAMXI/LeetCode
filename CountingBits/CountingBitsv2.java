package CountingBits;

public class CountingBitsv2 {
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

    // Returns an array where the i-th element is the number of 1s in the binary representation of i
    public static int[] countBits(int n){
        int[] result = new int[n + 1];  // Initialize the result array of size n+1 (to include 0)

        // Loop from 1 to n to compute bit counts
        for (int i = 1; i <= n; i++) {
            // result[i >> 1] gives the number of 1s in i divided by 2 (i shifted right by 1)
            // (i & 1) is 1 if the least significant bit is 1 (i is odd), otherwise 0
            result[i] = result[i >> 1] + (i & 1);
        }

        return result;
    }
}
/* 
 * The above code is an optimized version of the Counting Bits problem.
 * It uses bit manipulation to count the number of 1s in the binary 
 * representation of each number from 0 to n.
 */
