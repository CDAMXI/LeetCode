public class ContainsDuplicatesIIv1 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1,0,1,1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k){
        if (nums.length <= 1) {return false;}
        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++){
                if (i == j) {continue;}
                if (nums[i] == nums[j] && j - i <= k) {return true;}
            }
        }
        return false;
    }
}
