def addDigits(n):
    """Return the sum of all digits in n."""
    total = 0
    while n > 0:
        total += n % 10
        n //= 10
    return total

if __name__ == "__main__":
    test_cases = [38, 0, 12345, 9, 99999]
    for n in test_cases:
        result = addDigits(n)
        print(f"addDigits({n}) = {result}")
