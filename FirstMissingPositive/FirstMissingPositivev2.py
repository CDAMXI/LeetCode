def FirstMissingPositive(nums):
    # Eliminate non-useful numbers and duplicates
    nums = sorted(set([x for x in nums if x > 0]))
    
    # Find the first gap
    expected = 1
    for num in nums:
        if num == expected:
            expected += 1
        elif num > expected:
            return expected
    return expected  # If no positive integer is missing, return the next one

if __name__ == "__main__":
    nums = list(map(int, input("Enter a list of integers separated by spaces: ").strip().split()))
    result = FirstMissingPositive(nums)
    print(f"The first missing positive integer is: {result}")
