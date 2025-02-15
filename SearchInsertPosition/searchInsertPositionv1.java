package SearchInsertPosition;

public class searchInsertPositionv1 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1,3,5,6}, 5));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 2));
        System.out.println(searchInsert(new int[] {1,3,5,6}, 7));
    }

    public static int searchInsert(int[] nums, int target){
        if (nums.length == 0) {return 0;}
        return searchInsert(nums, target,0,nums.length-1, nums.length/2);
    }

    public static int searchInsert(int[] nums, int target,int ini,int fin, int midPoint){
        if (nums.length == 1) {
            if (nums[0] < target) {return fin;}
            else{return ini;}
        }
        else if (nums[midPoint] == target) {return midPoint;}
        else if(nums[midPoint] > nums[midPoint--] && nums[midPoint] < nums[midPoint++]){return midPoint++;}
        else if (target < nums[midPoint]) {return searchInsert(nums, target, ini,midPoint, midPoint);}
        else {return searchInsert(nums, target, midPoint,fin, midPoint);}
    }
}
