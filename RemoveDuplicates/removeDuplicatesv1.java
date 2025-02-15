package RemoveDuplicates;

public class removeDuplicatesv1 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,2}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,2,3,4}));
        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates(new int[]{}));
    }

    public static int removeDuplicates(int[] nums){
        int[] aux = new int[nums.length];
        if (nums.length == 1) {return 1;}
        if (nums.length < 1) {return 0;}
        int k = 0;
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] != nums[i+1]){
                k+=1;
                aux[pos] = nums[i];
                pos++;
            }
            if(i == nums.length - 1 && nums[i] != nums[i - 1]){
                k+=1;
                aux[pos] = nums[i];
                pos++;
            }
        }
        nums = aux;
        return k;
    }
}
