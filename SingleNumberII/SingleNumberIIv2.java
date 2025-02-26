import java.util.*;

public class SingleNumberIIv2 {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2,2,3,2}));
        System.out.println(singleNumber(new int[]{0,1,0,1,0,1,99}));
        System.out.println(singleNumber(new int[]{30000,500,100,30000,100,30000,100}));
    }

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        // First pass: Count the occurrences of each number
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Second pass: Find the first number that appears only once
        for (int num : nums) {
            if (countMap.get(num) == 1) {
                return num; // Returns the first unique number found
            }
        }

        return -1; // Returns a default value if no unique numbers
    }
}
