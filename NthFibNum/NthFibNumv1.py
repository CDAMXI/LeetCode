def nth_fib_num(n: int) -> int:
    """
    Calculates the nth Fibonacci number using big integers.
    Equivalent to the Java version that uses BigInteger.
    """
    if n == 0:
        return 0
    if n == 1:
        return 1

    prev, curr = 0, 1
    for _ in range(2, n + 1):
        prev, curr = curr, prev + curr

    return curr


if __name__ == "__main__":
    print("Fibonacci Sequence Calculator")
    print("Type 'exit' to quit the program.\n")

    while True:
        user_input = input("Enter the position of the Fibonacci sequence: ")

        if user_input.lower() == "exit":
            print("Exiting program. Goodbye!")
            break

        try:
            n = int(user_input)
            if n < 0:
                print("Please enter a non-negative integer.\n")
                continue

            fib_value = nth_fib_num(n)
            print(f"The {n}th value of the Fibonacci sequence is: {fib_value}\n")

        except ValueError:
            print("Invalid input. Please enter a valid integer.\n")
