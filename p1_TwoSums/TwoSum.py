def TwoSum(nums, target):
    # Removed the 'self' parameter, as this is a standalone function, not a class method.
    for i in range(len(nums)):
        # Start 'j' at 'i + 1' so you don't use the same element twice.
        for j in range(i + 1, len(nums)):
            if nums[i] + nums[j] == target:
                # Return a new list directly instead of trying to assign by index to an empty list.
                return [i, j]

# Renamed the variable to avoid confusion with the function's internal variables
nums_list = [2, 7, 11, 15]
print(TwoSum(nums_list, 9))
