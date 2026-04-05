def addDigits(n):
    if n < 10:
        return n
    else:
        return (n % 10) + addDigits(n // 10)
    
if __name__ == "__main__":
    test_cases = [38, 0, 12345, 9, 99999]
    for n in test_cases:
        result = addDigits(n)
        print(f"addDigits({n}) = {result}")
