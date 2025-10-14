def multiply(num1: str, num2: str) -> str:
    # If either number is "0", the result is "0"
    if num1 == "0" or num2 == "0":
        return "0"

    m, n = len(num1), len(num2)
    result = [0] * (m + n)

    # Traverse both strings from the end
    for i in range(m - 1, -1, -1):
        digit1 = ord(num1[i]) - ord('0')
        for j in range(n - 1, -1, -1):
            digit2 = ord(num2[j]) - ord('0')
            _sum = digit1 * digit2 + result[i + j + 1]

            result[i + j + 1] = _sum % 10          # Store the unit digit
            result[i + j] += _sum // 10            # Carry over to the next position

    # Convert the array to a string (skip leading zeros)
    sb = []
    for num in result:
        if not (len(sb) == 0 and num == 0):
            sb.append(str(num))

    return ''.join(sb) if sb else "0"


# Example usage (same as your Java main)
print(multiply("123", "456"))  # Output: 56088
print(multiply("0", "456"))    # Output: 0
