import java.util.*;

public class SortColorsv1 {
    public static void main(String[] args){
        int [] nums = {2,0,2,1,1,0};
        sortColors(nums);
        System.out.print("[");
        for (int i = 0; i < nums.length - 1; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println(nums[nums.length - 1] + "]");
    }

    public static void sortColors(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            arrayList.add(nums[i]);
        }
        arrayList.sort(null);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arrayList.get(i);
        }
    }
    
}
