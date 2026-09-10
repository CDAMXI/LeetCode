package p3904_SmallestStableIndexII;

import java.util.stream.IntStream;

public class SmallestStableIndexIIv1 {
    public static void main(String[] args){
        int[] nums = {5,0,1,4};
        int k = 3;

        System.out.println(firstStableIndex(nums, k));

        nums = new int[]{5, 5};
        k = 2;

        System.out.println(firstStableIndex(nums, k));
    }

    public static int firstStableIndex(int[] nums, int k){
        if(nums.length == 0){return -1;}
        if(nums.length == 1){return 0;}

        if(IntStream.range(0, nums.length - 1).allMatch(i -> nums[i] > nums[i + 1])){return -1;}
        if (IntStream.range(0, nums.length - 1).allMatch(i -> nums[i] == nums[i + 1])) {return 0;}
        if (IntStream.range(0, nums.length - 1).allMatch(i -> nums[i] < nums[i + 1])) {return 0;}

        int min, max;
        int rightIndex = 1;

        while(rightIndex < nums.length){
            min = nums[rightIndex];
            max = nums[0];

            for(int i = 0; i <= rightIndex; i++){
                if(nums[i] > max){
                    max = nums[i];
                }
            }

            for(int i = rightIndex; i < nums.length; i++){
                if(nums[i] < min){
                    min = nums[i];
                }
            }

            if(max - min <= k){
                return rightIndex;
            }else {
                rightIndex++;
            }
        }

        return -1;
    }
}
