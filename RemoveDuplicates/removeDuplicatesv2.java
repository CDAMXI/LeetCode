package RemoveDuplicates;

public class removeDuplicatesv2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,2,3,4}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0; // Edge case: empty array
    
        int k = 1; // Counter of unique elements, we start with the first element
        for (int i = 1; i < nums.length; i++) {
            // If the current number is different from the last unique found
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i]; // Updates the next place in nums
                k++;               // Increment the counter
            }
        }
        return k; // Number of unique elements
    }
    
}
