package MoveZeros;

public class MoveZerosv2 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.print("Input: [");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(nums[i] + ", ");
            } else {
                System.out.print(nums[i]);
            }
        }
        System.out.println("]");

        moveZeros(nums);

        System.out.print("Output: [");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {
                System.out.print(nums[i] + ", ");
            } else {
                System.out.print(nums[i]);
            }
        }
        System.out.println("]");
    }

    public static void moveZeros(int[] nums) {
        if (nums == null || nums.length == 0){return;}

        int lastNonZeroFoundAt = 0;

        // First pass: move all non-zeros forward
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {nums[lastNonZeroFoundAt++] = nums[i];}
        }

        // Second pass: fill the rest with zeros
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {nums[i] = 0;}
    }
}

