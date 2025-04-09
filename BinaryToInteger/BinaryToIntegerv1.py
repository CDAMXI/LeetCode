def BinaryToInteger(n):
    """
    Convert a binary number (as a string) to an integer.
    
    Args:
    n (str): A string representing a binary number.
    
    Returns:
    int: The integer value of the binary number.
    
    Raises:
    ValueError: If the input string is not a valid binary number.
    """
    # Check if the input is a valid binary number
    if not all(char in '01' for char in n):
        raise ValueError("Input must be a binary number (string of 0s and 1s).")
    
    # Convert binary string to integer
    return int(n, 2)

while True:
    n = int(input("Enter a binary number (or -1 to exit): "))
    if n == -1:
        break
    try:
        result = BinaryToInteger(str(n))
        print(f"The integer value of binary {n} is: {result}")
    except ValueError as e:
        print(n + " is not a valid binary number.")
