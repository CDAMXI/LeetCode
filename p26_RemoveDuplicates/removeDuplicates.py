def removeDuplicates(nums):
    """
    Removes duplicates from a sorted list of integers in-place and returns the new length of the list.
    
    :param nums: List[int] - A sorted list of integers
    :return: int - The length of the list after removing duplicates
    """
    if not nums:
        return 0

    # Initialize the index for the next unique element
    unique_index = 1

    for i in range(1, len(nums)):
        # If the current number is different from the last unique number, it's a new unique number
        if nums[i] != nums[unique_index - 1]:
            nums[unique_index] = nums[i]
            unique_index += 1

    return unique_index

print(removeDuplicates([1, 1, 2]))  # Output: 2
print(removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]))  # Output: 5
