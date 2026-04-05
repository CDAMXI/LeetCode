def FindFirstAndLastPosition(nums, target):
    def find_left(nums, target):
        left, right = 0, len(nums) - 1
        first = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                first = mid
                right = mid - 1  # sigue buscando más a la izquierda
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return first

    def find_right(nums, target):
        left, right = 0, len(nums) - 1
        last = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                last = mid
                left = mid + 1  # sigue buscando más a la derecha
            elif nums[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
        return last

    return [find_left(nums, target), find_right(nums, target)]


if __name__ == "__main__":
    nums = list(map(int, input("Enter the sorted array (space-separated): ").split()))
    target = int(input("Enter the target value: "))
    result = FindFirstAndLastPosition(nums, target)
    print(f"First and Last Position of {target} in the array: {result}")
