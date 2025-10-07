def FirstUniqueCharInString(n):
    if len(n) == 0:
        return -1
    if len(n) == 1:
        return 0

    char_count = {}
    for char in n:
        char_count[char] = char_count.get(char, 0) + 1

    # recorrer el string original para mantener el orden
    for i, char in enumerate(n):
        if char_count[char] == 1:
            return i
    return -1


if __name__ == "__main__":
    print(FirstUniqueCharInString("leetcode"))       # Output: 0
    print(FirstUniqueCharInString("loveleetcode"))   # Output: 2
    print(FirstUniqueCharInString(""))               # Output: -1
    print(FirstUniqueCharInString("aabb"))           # Output: -1
    print(FirstUniqueCharInString("a"))              # Output: 0
