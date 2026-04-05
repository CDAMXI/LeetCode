package JumpGame;

public class JumpGamev2 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    /**
     * Greedy: track the farthest index reachable so far.
     * Time: O(n) — single pass
     * Space: O(1)
     */
    public static boolean canJump(int[] nums) {
        // Handle edge cases explicitly
        if (nums == null || nums.length == 0){return false;}
        if (nums.length == 1){return true;} // already at the last index
        
        int farthest = 0;
        // Iterate only until the current farthest reach; beyond that it's unreachable
        for (int i = 0; i <= farthest && i < nums.length; i++) {
            // Update farthest reach from position i
            int candidate = i + nums[i];
            if (candidate > farthest) {
                farthest = candidate;
                // Early exit if we can already reach the last index
                if (farthest >= nums.length - 1){return true;}
            }
        }
        // If loop finishes without early exit, we couldn't reach the end
        return false;
    }
}
