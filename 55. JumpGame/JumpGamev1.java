package JumpGame;

public class JumpGamev1{
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }

    public static boolean canJump(int[] nums) {
        int jumps = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(jumps == 0){return false;}
            jumps--;
            jumps = Math.max(jumps, nums[i]);
        }
        return true;
    }
}
