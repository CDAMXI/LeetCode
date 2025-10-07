def is_happy(n):
    if n == 1:
        return True
    if n == 4:
        return False

    total = 0
    while n > 0:
        total += (n % 10) ** 2
        n //= 10

    return is_happy(total)


if __name__ == "__main__":
    print(is_happy(19))  # True
    print(is_happy(2))   # False
