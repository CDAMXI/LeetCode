package SingleNumber;

public class singleNumberv2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
    }

    public static int singleNumber(int[] nums) {
        int result = 0; //  Initialize the result with 0
        for (int num : nums) {
            result ^= num; // Apply XOR with each number
        }
        return result; // The unique number remains at the end
    }
    
}
