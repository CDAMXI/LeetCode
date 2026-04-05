package NextPermutation;

public class NextPermutationv1 {
    public static void main(String[] args) {
        int[] result = nextPermutation(new int[]{1,2,3});
        for(int i : result){System.out.print(i + " ");}
    }

    public static int[] nextPermutation(int[] nums){
        int last = nums[nums.length - 1];
        for(int i = nums.length - 1; i >= 1; i--){
            if(i == 1){nums[i] = last; break;}
            nums[i] = nums[i - 1];
        }
        return nums;
    }
}
