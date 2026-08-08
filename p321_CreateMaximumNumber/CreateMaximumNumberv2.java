package p321_CreateMaximumNumber;

public class CreateMaximumNumberv2 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        CreateMaximumNumberv2 solution = new CreateMaximumNumberv2();
        int[] result = solution.maxNumber(nums1, nums2, k);
        System.out.println(java.util.Arrays.toString(result));
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Pre-allocate buffers exactly once to achieve O(k) strict memory usage
        int[] bestResult = new int[k];
        int[] currentMerge = new int[k];
        int[] part1 = new int[k];
        int[] part2 = new int[k];
        
        int start = Math.max(0, k - n);
        int end = Math.min(k, m);
        
        for (int i = start; i <= end; i++) {
            // Populate the buffers directly instead of returning new arrays
            maxArray(nums1, i, part1);
            maxArray(nums2, k - i, part2);
            
            // Merge into our reusable currentMerge buffer
            merge(part1, i, part2, k - i, currentMerge);
            
            // Compare the newly merged array with our absolute best result
            if (compare(currentMerge, 0, k, bestResult, 0, k)) {
                // Highly optimized native memory copy
                System.arraycopy(currentMerge, 0, bestResult, 0, k);
            }
        }
        
        return bestResult;
    }
    
    // Helper 1: Writes the maximum subsequence directly into the pre-allocated 'out' buffer
    private void maxArray(int[] nums, int len, int[] out) {
        if (len == 0) return;
        int top = 0; 
        int drop = nums.length - len; 
        
        for (int num : nums) {
            while (drop > 0 && top > 0 && out[top - 1] < num) {
                top--;
                drop--;
            }
            if (top < len) {
                out[top++] = num;
            } else {
                drop--; 
            }
        }
    }
    
    // Helper 2: Merges the valid portions of part1 and part2 into the 'out' buffer
    private void merge(int[] part1, int len1, int[] part2, int len2, int[] out) {
        int i = 0, j = 0;
        int totalLen = len1 + len2;
        
        for (int r = 0; r < totalLen; r++) {
            if (compare(part1, i, len1, part2, j, len2)) {
                out[r] = part1[i++];
            } else {
                out[r] = part2[j++];
            }
        }
    }
    
    // Helper 3: Lexicographically compares arrays up to their specific valid lengths
    private boolean compare(int[] arr1, int i, int len1, int[] arr2, int j, int len2) {
        while (i < len1 && j < len2 && arr1[i] == arr2[j]) {
            i++;
            j++;
        }
        return j == len2 || (i < len1 && arr1[i] > arr2[j]);
    }
}
