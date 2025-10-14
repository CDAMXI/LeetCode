def missingNumber(nums):
    length = len(nums)
    expectedSum = length * (length + 1) // 2
    actualSum = 0
    
    return expectedSum - sum(nums)

print("Note: if 0 is missing from your input, it will be added automatically for testing.")
nums = list(map(int, input("Enter a list of integers separated by spaces: ").strip().split()))
nums.sort()
if 0 in nums:
    print(f"The missing number is {missingNumber(nums)}")
else:
    nums.append(0)
    print(f"The missing number is {missingNumber(nums)}")
