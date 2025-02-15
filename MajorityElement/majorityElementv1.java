package MajorityElement;

import java.util.HashMap;

public class majorityElementv1 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
    }

    public static int majorityElement(int[] nums) {
        int value = 0, n = nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(nums[num])) {map.put(nums[num], map.get(num) + 1);}
            else{map.put(nums[num],map.get(num)+1);}
        }

        for (int key : map.keySet()) {
            if (map.get(key)>n) {value = key;}
        }
        return value;
    }
}
