public class RemoveDuplicatesFromSortedArrayIIv1{
    public static void main(String[] args){
        System.out.println("For: \"[1,1,1,2,2,3]\" the output is: " + removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0) {return 0;}
        Arrays.sort(nums);
        int count = nums[0];
        ArrayList<Integer> list = new ArrayList<>();
        list.add(count);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != count) {
                count = nums[i];
                list.add(count);
            }
        }

        for(int i = 0; i < list.size(); i++) {
            count += list.get(i);
        }
    }
}
