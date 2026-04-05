def devideTwoIntegers(dividend: int, divisor: int) -> int:
    # Handle edge case of overflow
    if dividend == -2**31 and divisor == -1:
        return 2**31 - 1

    # Determine the sign of the quotient
    negative = (dividend < 0) ^ (divisor < 0)

    # Work with absolute values to simplify the division process
    dividend, divisor = abs(dividend), abs(divisor)
    quotient = 0

    # Subtract the divisor from the dividend until what's left is less than the divisor
    while dividend >= divisor:
        temp, multiple = divisor, 1
        while dividend >= temp:
            dividend -= temp
            quotient += multiple
            temp <<= 1  # Double the temp value
            multiple <<= 1  # Double the multiple value

    return -quotient if negative else quotient

if __name__ == "__main__":
    # Example usage
    print(devideTwoIntegers(10, 3))  # Output: 3
    print(devideTwoIntegers(7, -3))  # Output: -2
    print(devideTwoIntegers(-2147483648, -1))  # Output: 2147483647
