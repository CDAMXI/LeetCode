def FindAllMissingNumsInArray(nums):
    # Convert to set for fast lookup
    num_set = set(nums)
    missing = []
    
    # Loop from 1 to length of the original list
    for i in range(1, len(nums) + 1):
        if i not in num_set:
            missing.append(i)
    
    return missing

if __name__ == "__main__":
    nums = [4,3,2,7,8,2,3,1]
    print(FindAllMissingNumsInArray(nums))
