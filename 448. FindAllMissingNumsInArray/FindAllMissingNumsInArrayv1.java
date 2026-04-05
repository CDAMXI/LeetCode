import java.util.*;

public class FindAllMissingNumsInArrayv1{
    public static void main(String[] args) {
        System.out.println(" The missing numbers in [1,1] are:" + findDisappearedNumbers(new int[]{1, 1}));
        System.out.println(" The missing numbers in [4,3,2,7,8,2,3,1] are:" + findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1}));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums){
        Arrays.sort(nums);
        List<Integer> missingNumbers = new ArrayList<>();
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1] + 1){missingNumbers.add(nums[i-1] + 1);}
        }
        return missingNumbers;
    }
}
