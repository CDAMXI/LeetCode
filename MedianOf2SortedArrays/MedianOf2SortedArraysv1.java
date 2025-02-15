package MedianOf2SortedArrays;

public class MedianOf2SortedArraysv1 {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length == 0 && nums2.length == 0){return -1;}
        int[] merged = mergeSortedArrays(nums1, nums2);
        int midPoint = merged.length/2;
        if (merged.length % 2 == 0) {return (merged[midPoint] + merged[midPoint - 1])/2.0;}
        else{return merged[midPoint];}
    }

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int n1 = arr1.length, n2 = arr2.length;
        int[] result = new int[n1 + n2];
        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements from arr1
        while (i < n1) {
            result[k++] = arr1[i++];
        }

        // Copy remaining elements from arr2
        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

}
