package ContainsDuplicates;

import java.util.HashMap;

public class containsDuplicatesv1 {
    public static void main(String[] args) {
        System.out.println(ContainsDuplicates(new int[]{1,2,3,1}));
        System.out.println(ContainsDuplicates(new int[]{1,2,3,4}));
        System.out.println(ContainsDuplicates(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean ContainsDuplicates(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {map.put(num, map.get(num) + 1);}
            else {map.put(num, 1);}
        }

        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                return true;
            }
        }
        return false;
    }
}
