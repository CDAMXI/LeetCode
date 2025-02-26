package RemoveElement;

public class removeElementv3 {
    public static void main(String[] args) {
        System.out.println("Solution: " + removeElement(new int[]{3,2,2,3}, 3));       
        System.out.println("Solution: " + removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));       
    }

    public static int removeElement(int[] nums, int val){
        if (nums.length == 0) {
            return 0;
        }
        int k = 0;
        
        // Move the values that are not equal to `val` to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        
        // Fill the last `nums.length - k` elements with zeros
        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
        
        return k; // Resturn the number of elements that are not equal to `val`
    }
}
