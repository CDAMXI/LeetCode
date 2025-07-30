public class RemoveDuplicatesFromSortedArrayIIv1{
    public static void main(String[] args){
        System.out.println("For: \"[1,1,1,2,2,3]\" the output is: " + removeDuplicates(new int[]{1,1,1,2,2,3}));
        System.out.println("For: \"[0,0,1,1,1,1,2,3,3]\" the output is: " + removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {return 0;}
        int sum = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count != 2 && nums[i] == nums[i - 1]){
                count++;
                sum += nums[i];
            }
            else{count = 1;}
        }
    }
}
