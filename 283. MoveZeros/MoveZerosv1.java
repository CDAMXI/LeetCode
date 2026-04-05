package MoveZeros;

public class MoveZerosv1 {
    public static void main(String[] args){
        int[] nums = {0, 1, 0, 3, 12};
        System.out.print("Input: [");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {System.out.print(nums[i] + ", ");}
            else {System.out.print(nums[i]);}
        }
        System.out.println("]");
        moveZeros(nums);
        System.out.print("Output: [");
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1) {System.out.print(nums[i] + ", ");}
            else {System.out.print(nums[i]);}
        }
        System.out.println("]");
    }

    public static void moveZeros(int[] nums) {
        if(nums == null || nums.length == 0){return;}
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if ((i+1) != nums.length-1 && nums[i+1] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    i = -1; // Reset i to start from the beginning again
                } else {break;}
            }
        }
    }
}
