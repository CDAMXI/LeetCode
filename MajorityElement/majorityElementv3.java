package MajorityElement;

public class majorityElementv3 {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3, 2, 3}));  // Output: 3
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));  // Output: 2
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1}));  // Output: 1
    }

    public static int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        
        // Phase 1: Find a potential candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;  // Assign a new candidate
            }
            count += (num == candidate) ? 1 : -1;  // Increment or decrement the counter
        }
        
        // Phase 2: (Optional) Validation (not needed in this case, since the problem guarantees a majority element)
        // count = 0;
        // for (int num : nums) {
        //     if (num == candidate) count++;
        // }
        // if (count > nums.length / 2) return candidate;

        return candidate;  // The candidate will be the majority element
    }
}
