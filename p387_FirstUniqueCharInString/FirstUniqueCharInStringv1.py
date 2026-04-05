def FirstUniqueCharInString(n):
    if(len(n) == 0):
        return -1
    if(len(n) == 1):
        return 0
    char_count = {}
    for char in n:
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1
    char_count = char_count.sort()
    return char_count[0][0]

if __name__ == "__main__":
    print(FirstUniqueCharInString("leetcode"))  # Output: 0
    print(FirstUniqueCharInString("loveleetcode"))  # Output: 2
    print(FirstUniqueCharInString(""))  # Output: -1
    print(FirstUniqueCharInString("aabb"))  # Output: -1
    print(FirstUniqueCharInString("a"))  # Output: 0
