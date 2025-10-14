def moveZeros(nums):
    if not nums:
        return
    last = 0
    for i in range(len(nums)):
        if nums[i] != 0:
            nums[last] = nums[i]
            last += 1
    for i in range(last, len(nums)):
        nums[i] = 0

nums = list(map(int, input("Enter a list of integers separated by spaces: ").split()))
moveZeros(nums)
print("The output is:", nums)
