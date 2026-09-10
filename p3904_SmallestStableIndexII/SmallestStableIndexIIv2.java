package p3904_SmallestStableIndexII;

public class SmallestStableIndexIIv2 {
    public static void main(String[] args){
        int[] nums = {5,0,1,4};
        int k = 3;

        System.out.println(firstStableIndex(nums, k));

        nums = new int[]{5, 5};
        k = 2;

        System.out.println(firstStableIndex(nums, k));
    }

    public static int firstStableIndex(int[] nums, int k){
        int n = nums.length;
        if (n == 0) return -1;

        int[] prefixMax = new int[n];
        int[] suffixMin = new int[n];

        prefixMax[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
        }

        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (prefixMax[i] - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
