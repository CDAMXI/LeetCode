import java.util.Arrays;

public class FindFirstAndLastPositionv1{
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {return new int[]{-1, -1};}
        if(nums.length == 1 && nums[0] == target){return new int[]{0,0};}
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && result[0] == 0) {result[0] = i;}
            if (nums[i] == target) {result[1] = i;}
            if (nums[i] > target) {break;}
        }
        if (result[0] == 0 && result[1] == 0) {return new int[]{-1, -1};}
        return result;
    }
}
