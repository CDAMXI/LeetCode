package IntersectionOfTwoArraysII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysIIv1 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
        // Output: [2, 2]
    }

    public static int[] intersection(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){list.add(nums1[i]);}
            }
        }

        int[] result = new int[list.size()/2];
        for(int i = 0; i < list.size()/2; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
