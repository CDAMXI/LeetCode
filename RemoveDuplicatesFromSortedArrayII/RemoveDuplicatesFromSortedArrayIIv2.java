public class RemoveDuplicatesFromSortedArrayIIv2 {

    public static void main(String[] args) {
        System.out.println("For \"[1,1,1,2,2,3]\", new length = " + removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}) + ", modified array = " + arrayToString(new int[]{1, 1, 1, 2, 2, 3}, removeDuplicates(new int[]{1, 1, 1, 2, 2, 3})));

        System.out.println("For \"[0,0,1,1,1,1,2,3,3]\", new length = " + removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}) + ", modified array = " + arrayToString(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3})));

        System.out.println("For \"[3,4]\", new length = " + removeDuplicates(new int[]{3,4}) + ", modified array = " + arrayToString(new int[]{3,4}, removeDuplicates(new int[]{3,4})));
        
        System.out.println("For \"[25]\", new length = " + removeDuplicates(new int[]{25}) + ", modified array = " + arrayToString(new int[]{25}, removeDuplicates(new int[]{25})));
        
        System.out.println("For \"[]\", new length = " + removeDuplicates(new int[]{}) + ", modified array = " + arrayToString(new int[]{}, removeDuplicates(new int[]{})));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums == null) {return 0;}
        if (nums.length <= 2) {return nums.length;}

        int insertPos = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[insertPos - 2]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        return insertPos;
    }

    private static String arrayToString(int[] arr, int length) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(arr[i]);
            if (i < length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
