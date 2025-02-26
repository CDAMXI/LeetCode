package ContainsDuplicates;

import java.util.HashSet;

public class containsDuplicatesv3 {
    public static void main(String[] args) {
        System.out.println(ContainsDuplicates(new int[]{1,2,3,1}));
        System.out.println(ContainsDuplicates(new int[]{1,2,3,4}));
        System.out.println(ContainsDuplicates(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean ContainsDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true; // A duplicate has been found
            }
            set.add(num);
        }
        return false; // There are no duplicates
    }
}
