def FindAllMissingNumsInArray(nums):
    nums = set(nums).sorted()
    num_set = set(nums)
    for i in range(1, len(nums) + 1):
        if i not in num_set:
            nums.append(i)
    return nums

if __name__ == "__main__":
    nums = [4,3,2,7,8,2,3,1]
    print(FindAllMissingNumsInArray(nums))
