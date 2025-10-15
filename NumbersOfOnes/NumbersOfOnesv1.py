def countDigitOne(n):
    count, factor = 0, 1

    while factor <= n:
        lower = n % factor
        current = (n // factor) % 10
        higher = n // (factor * 10)

        if current == 0:
            count += higher * factor
        elif current == 1:
            count += higher * factor + lower + 1
        else:
            count += (higher + 1) * factor

        factor *= 10

    return count


n = int(input("Introduce a number: "))
num1 = countDigitOne(n)

if num1 == 1:
    print(f"{n} has a total of one 1.")
else:
    print(f"{n} has a total of {num1} ones.")
