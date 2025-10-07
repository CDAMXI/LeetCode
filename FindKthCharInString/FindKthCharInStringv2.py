def find_kth_char(s: str, k: int) -> str:
    """Return the k-th character (1-indexed) of a string."""
    if not s:
        return "Error: empty string"
    if not isinstance(k, int):
        return "Error: k must be an integer"
    if not 1 <= k <= len(s):
        return "Error: k is out of bounds"
    return s[k - 1]

if __name__ == "__main__":
    s = input("Enter the string: ").strip()
    k = int(input("Enter the value of k: "))
    result = find_kth_char(s, k)
    print(f"The {k}th character in the string is: {result}")
