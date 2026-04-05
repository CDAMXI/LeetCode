def findMaxConsecutiveOnes(nums):
    maxCount = currentCount = 0
    
    for num in nums:
        if num == 1:
            currentCount += 1
            maxCount = max(maxCount, currentCount)
        else:
            currentCount = 0
    
    return maxCount

print(findMaxConsecutiveOnes([1,1,0,1,1,1]))  # → 3
print(findMaxConsecutiveOnes([1,0,1,1,0,1]))  # → 2
