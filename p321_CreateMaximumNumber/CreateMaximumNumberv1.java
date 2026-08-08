package p321_CreateMaximumNumber;

import java.util.Arrays;
import java.util.Collections;

public class CreateMaximumNumberv1{
    public static void main(String[] args){
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] result = maxNumber(nums1, nums2, k);
        System.out.println(Arrays.toString(result));
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k){
        int[] result = new int[k];

        if (nums1 == null || nums2 == null || k <= 0 || (nums1.length + nums2.length) < k){
            return result;
        }

        if(nums1.length + nums2.length == k){
            int[] temp = new int[nums1.length + nums2.length];
            System.arraycopy(nums1, 0, temp, 0, nums1.length);
            System.arraycopy(nums2, 0, temp, nums1.length, nums2.length);
            return temp;
        }

        nums1 = Arrays.stream(nums1).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        nums2 = Arrays.stream(nums2).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();

        int i = 0;
        int j = 0;
        int l = 0;

        while (l < k){
            if (i < nums1.length && j < nums2.length){
                if(nums1[i] == nums2[j]){
                    result[l++] = nums1[i++];
                    j++;
                }
                else if (nums1[i] > nums2[j]){
                    result[l++] = nums1[i++];
                    j++;
                } else {
                    result[l++] = nums2[j++];
                    //i++;
                }
            } else if (i < nums1.length){
                result[l++] = nums1[i++];
            } else {
                result[l++] = nums2[j++];
            }
        }

        return result;
    }
}
