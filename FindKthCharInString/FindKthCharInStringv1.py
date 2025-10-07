def FindKthCharInString(s, k):
    if k <= 0 or k > len(s):
        return "Error: k is out of bounds"
    return s[k - 1]

if __name__ == "__main__":
    s = input("Enter the string: ")
    k = int(input("Enter the value of k: "))
    result = FindKthCharInString(s, k)
    print(f"The {k}th character in the string is: {result}")
