public class SingleNumberIIIv3 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 3, 2})); // Output: 3
        System.out.println(singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99})); // Output: 99
        System.out.println(singleNumber(new int[]{30000, 500, 100, 30000, 100, 30000, 100})); // Output: 500
    }

    public static int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones; // 'ones' contiene el número que aparece solo una vez
    }
}
