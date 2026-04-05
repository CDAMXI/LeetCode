def canJump(nums):
    if not nums: 
        return False
    if len(nums) == 1: 
        return True

    farthest = 0
    i = 0
    while i <= farthest and i < len(nums):
        candidate = i + nums[i]
        if candidate > farthest:
            farthest = candidate
            if farthest >= len(nums) - 1:
                return True
        i += 1

    return False

nums = list(map(int, input("Enter a list of integers separated by spaces: ").strip().split()))
if canJump(nums): print(f"{nums} can INDEED jump.")
else: print(f"{nums} CANNOT jump.")
