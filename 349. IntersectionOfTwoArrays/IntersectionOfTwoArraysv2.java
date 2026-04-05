import java.util.*;

public class IntersectionOfTwoArraysv2{
    public static void main(String[] args){
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        // Output: [2, 2]
    }

    public static int[] intersection(int[] nums1, int[] nums2){
        return Arrays.stream(nums1)
                .filter(num -> Arrays.stream(nums2).anyMatch(n -> n == num))
                .distinct()
                .toArray();
    }
}
