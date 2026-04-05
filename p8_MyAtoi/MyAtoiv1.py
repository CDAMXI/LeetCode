def myAtoi(s: str) -> int:
    # Handle empty or None input
    if not s:
        return 0

    index, sign, result = 0, 1, 0
    INT_MAX, INT_MIN = 2**31 - 1, -2**31

    # 1. Ignore leading spaces
    while index < len(s) and s[index] == ' ':
        index += 1

    # 2. Handle optional sign
    if index < len(s) and (s[index] == '+' or s[index] == '-'):
        sign = -1 if s[index] == '-' else 1
        index += 1

    # 3. Read digits until a non-digit character is found
    while index < len(s) and s[index].isdigit():
        digit = ord(s[index]) - ord('0')

        # 4. Handle overflow and underflow
        if result > INT_MAX // 10 or (result == INT_MAX // 10 and digit > INT_MAX % 10):
            return INT_MAX if sign == 1 else INT_MIN

        result = result * 10 + digit
        index += 1

    return result * sign


# Example tests (equivalent to your Java main)
print("Result:", myAtoi("42"))            # 42
print("Result:", myAtoi("-042"))          # -42
print("Result:", myAtoi("1337c0d3"))      # 1337
print("Result:", myAtoi("   -42"))        # -42
print("Result:", myAtoi("words and 987")) # 0
print("Result:", myAtoi("+-12"))          # 0
