def FindFirstAndLastPosition(nums, target):
    pos = [-1, -1]
    left, right = 0, len(nums) - 1
    for i in range(len(nums)):
        if nums[i] == target:
            pos[0] = i
            break
    for j in range(len(nums) - 1, -1, -1):
        if nums[j] == target:
            pos[1] = j
            break
    return pos

if __name__ == "__main__":
    nums = list(map(int, input("Enter the sorted array (space-separated): ").split()))
    target = int(input("Enter the target value: "))
    result = FindFirstAndLastPosition(nums, target)
    print(f"First and Last Position of {target} in the array: {result}")
