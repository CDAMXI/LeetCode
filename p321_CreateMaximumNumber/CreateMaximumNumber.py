from typing import List

class Solution:
    def maxNumber(self, nums1: List[int], nums2: List[int], k: int) -> List[int]:
        
        # Helper 1: Find the maximum subsequence of a specific length
        def max_array(nums, length):
            drop = len(nums) - length
            stack = []
            for num in nums:
                # Pop smaller elements from the stack if we still have the budget to drop
                while drop > 0 and stack and stack[-1] < num:
                    stack.pop()
                    drop -= 1
                stack.append(num)
            # Truncate to exact length (handles cases where elements are strictly decreasing)
            return stack[:length]

        best_result = []
        
        # Iterate through all valid ways to split the required k digits between nums1 and nums2
        # i represents the number of elements taken from nums1
        start = max(0, k - len(nums2))
        end = min(k, len(nums1))
        
        for i in range(start, end + 1):
            part1 = max_array(nums1, i)
            part2 = max_array(nums2, k - i)
            
            # Helper 2: Merge the two parts to form the maximum possible sequence.
            # Python's built-in max() handles lexicographical array comparisons in native C, 
            # making this operation surprisingly fast.
            merged = [max(part1, part2).pop(0) for _ in range(k)]
            
            # Keep the globally maximum array
            best_result = max(best_result, merged)
            
        return best_result
