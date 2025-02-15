public class SortColorsv2 {
    public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.print("[");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(nums[nums.length - 1] + "]");
    }

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low++, mid++);
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, high--);
                    break;
            }
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}
