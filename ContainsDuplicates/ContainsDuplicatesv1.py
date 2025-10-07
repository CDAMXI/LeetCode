def ContainsDuplicates(nums):
    """
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.
    """
    num_set = set()
    for num in nums:
        if num in num_set:
            return True
        num_set.add(num)
    return False

if __name__ == "__main__":
    # Example usage
    nums = [1, 2, 3, 1]
    print(ContainsDuplicates(nums))  # Output: True
