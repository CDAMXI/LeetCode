package SingleNumber;

import java.util.*;

public class singleNumberv1 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,1}));
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumber(new int[]{1}));
        System.out.println(singleNumber(new int[]{1,1,1,2,2,2}));
    }

    public static int singleNumber(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {map.put(num, map.get(num) + 1);}
            else {map.put(num, 1);}
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key; // Devolver la clave que tiene un valor de 1
            }
        }
        throw new IllegalArgumentException("No single number found"); 
    }
}
