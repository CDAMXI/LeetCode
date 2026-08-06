def maxArea(height: list[int]) -> int:
    left, right, maxArea = 0, len(height) - 1, 0
    
    while left < right:
        h = min(height[left], height[right])
        w = right - left
        maxArea = max(maxArea, h*w)
        
        if height[left] < height[right]:
            left+=1
        else:
            right-=1
    
    return maxArea

print(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7])) # Output: 49
print(maxArea([1, 1])) # Output: 1
