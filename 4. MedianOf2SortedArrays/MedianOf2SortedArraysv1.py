def findMedianSortedArrays(nums1, nums2):
    # If both arrays are empty, there is no valid median
    if not nums1 and not nums2:
        return -1

    # Ensure nums1 is always the smaller array
    if len(nums1) > len(nums2):
        nums1, nums2 = nums2, nums1

    left, right = 0, len(nums1)
    mid = (len(nums1) + len(nums2) + 1) // 2

    # Binary search
    while left <= right:
        partition1 = (left + right) // 2
        partition2 = mid - partition1

        # If there are no elements on the left, assign very low/high values
        maxLeft1 = float('-inf') if partition1 == 0 else nums1[partition1 - 1]
        minRight1 = float('inf') if partition1 == len(nums1) else nums1[partition1]

        maxLeft2 = float('-inf') if partition2 == 0 else nums2[partition2 - 1]
        minRight2 = float('inf') if partition2 == len(nums2) else nums2[partition2]

        # Check if we found the correct partition
        if maxLeft1 <= minRight2 and maxLeft2 <= minRight1:
            # If total length is odd, median is the max of left elements
            if (len(nums1) + len(nums2)) % 2 == 1:
                return max(maxLeft1, maxLeft2)
            else:
                # If even, median is the average of the two central values
                return (max(maxLeft1, maxLeft2) + min(minRight1, minRight2)) / 2.0
        elif maxLeft1 > minRight2:
            # Move partition1 to the left
            right = partition1 - 1
        else:
            # Move partition1 to the right
            left = partition1 + 1

    # If we reach here, something went wrong (arrays not sorted)
    raise ValueError("Input arrays are not sorted.")


# Test cases
print(findMedianSortedArrays([1, 3], [2]))        # Output: 2.0
print(findMedianSortedArrays([1, 2], [3, 4]))     # Output: 2.5
print(findMedianSortedArrays([1, 2], []))         # Output: 1.5
print(findMedianSortedArrays([], [3, 4]))         # Output: 3.5
