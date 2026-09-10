package p3904_SmallestStableIndexII;

public class SmallestStableIndexIIv3 {

    public static void main(String[] args) {
        System.out.println(firstStableIndex(new int[]{5, 0, 1, 4}, 3));   // esperado: 3
        System.out.println(firstStableIndex(new int[]{5, 5}, 2));         // esperado: 0
        System.out.println(firstStableIndex(new int[]{10, 9, 8, 7}, 3));  // esperado: 0 (contraejemplo bug rama decreciente)
        System.out.println(firstStableIndex(new int[]{1, 10, 0, 20}, 5)); // esperado: 0 (contraejemplo bug índice 0 ignorado)
        System.out.println(firstStableIndex(new int[]{5, 4, 3, 2, 1}, 0)); // esperado: -1
        System.out.println(firstStableIndex(new int[]{7}, 0));            // esperado: 0
    }

    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;

        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
        }

        int runningMax = nums[0];
        for (int i = 0; i < n; i++) {
            if (nums[i] > runningMax) {
                runningMax = nums[i];
            }
            if (runningMax - suffixMin[i] <= k) {
                return i;
            }
        }

        return -1;
    }
}
