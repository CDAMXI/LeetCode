package MedianOf2SortedArrays;

public class MedianOf2SortedArraysv2 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));  // Output: 2.0
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));  // Output: 2.5
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{}));  // Output: 1.5
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{3,4}));  // Output: 3.5
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // If both arrays are empty, it does not make sense to calculate the median
        if (nums1.length == 0 && nums2.length == 0) {
            return -1;
        }
        
        // Make sure nums1 is always the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        
        int left = 0, right = nums1.length, mid = (nums1.length + nums2.length + 1) / 2;
        
        // Binary search
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = mid - partition1;

            // If there are no elements on the left side, assign a very low value
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == nums1.length) ? Integer.MAX_VALUE : nums1[partition1];

            // Same for nums2
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == nums2.length) ? Integer.MAX_VALUE : nums2[partition2];

            // Check if we've found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If the length is odd, the median is the maximum of the left elements
                if ((nums1.length + nums2.length) % 2 == 1) {
                    return Math.max(maxLeft1, maxLeft2);
                } else {
                    // If the length is even, the median is the average of the two central values
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                }
            } else if (maxLeft1 > minRight2) {
                // Move left in nums1
                right = partition1 - 1;
            } else {
                // Move right in nums1
                left = partition1 + 1;
            }
        }
        
        // If we reach here, something went wrong
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }
}
