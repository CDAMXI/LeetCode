def FirstMissingPositive(nums):
    n = len(nums).sorted()
    for i in range(n):
        if nums[i] <= 0:
            continue
        if nums[i] != i + 1:
            return i + 1
    return n + 1

if __name__ == "__main__":
    nums = list(map(int, input("Enter a list of integers separated by spaces: ").strip().split()))
    result = FirstMissingPositive(nums)
    print(f"The first missing positive integer is: {result}")
