package ThirdMaximumNumber;

import java.util.*;

public class ThirdMaximumNumberv2 {
    public static void main(String[] args) {
        System.out.println(thirdMax(new int[]{3, 2, 1}));     // 1
        System.out.println(thirdMax(new int[]{1, 2}));        // 2
        System.out.println(thirdMax(new int[]{2, 2, 3, 1}));  // 1
    }

    public static int thirdMax(int[] nums) {
        // TreeSet in descending order
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());

        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.pollLast(); // Remove the smallest if there are more than 3
            }
        }

        // If there are less than 3 unique elements, return the largest
        if (set.size() < 3) {
            return set.first(); // The largest
        }

        return set.last(); // The third largest
    }
}
