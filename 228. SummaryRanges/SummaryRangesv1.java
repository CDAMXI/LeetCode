package SummaryRanges;

import java.util.*;

public class SummaryRangesv1{
    public static void main(String[] args){
        System.out.println(SummaryRanges(new int[]{0,1,2,4,5,7}));
    }

    public static List<String> SummaryRanges(int[] nums){
        List<String> result = new ArrayList<>();
        if(nums.length == 0){return result;}
        Arrays.sort(nums);
        int cont = 0;
        for(int i = 0; i < nums.length - 1; i++){
            String temp = "";
            if(nums[i] + 1 == nums[i+1]){
                cont++;
                temp = String.valueOf(nums[i])+",";
            } else{i = i + cont;}
            if(i == nums.length - 1){
                temp += String.valueOf(nums[i]);
                result.add(temp);
            } else if(cont > 0){
                temp += String.valueOf(nums[i]) + "->" + String.valueOf(nums[i+cont]);
                result.add(temp);
            } else{
                result.add(String.valueOf(nums[i]));
            }
        }
        return result;
    }
}
