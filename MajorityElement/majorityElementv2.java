package MajorityElement;

import java.util.HashMap;

public class majorityElementv2 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));         // Output: 3
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2})); // Output: 2
    }

    public static int majorityElement(int[] nums) {
        int value = 0, n = nums.length / 2;  // n is half the size of the array
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each number in nums
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);  // If num is not in the map, initialize it to 0 and increment
        }

        // Find the number whose frequency is greater than n
        for (int key : map.keySet()) {
            if (map.get(key) > n) {
                value = key;  // Save the value if its frequency is greater than n
                break;  // Terminate the loop once the majority element is found
            }
        }

        return value;
    }
}
// Time Complexity: O(n) where n is the length of the input array nums
// Space Complexity: O(n) where n is the length of the input array nums
