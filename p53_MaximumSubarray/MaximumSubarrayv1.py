def maxSubArray(nums):
    if not nums:
        return 0

    maxCurrent = maxGlobal = nums[0]

    for i in range(1, len(nums)):
        maxCurrent = max(nums[i], maxCurrent + nums[i])
        maxGlobal = max(maxGlobal, maxCurrent)

    return maxGlobal

nums = list(map(int, input("Enter a list of integers separated by spaces: ").strip().split()))
print(f"The maximum subarray sum in {nums} is: {maxSubArray(nums)}")
