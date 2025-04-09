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
    if not all(char in '01' for char in n):
        raise ValueError("Input must be a binary number (string of 0s and 1s).")
    
    return int(n, 2)

while True:
    user_input = input("Enter a binary number (or a negative number or 'exit' to quit): ").strip()

    if user_input.lower() == "exit":
        break
    if user_input.startswith('-') and user_input[1:].isdigit():
        break

    try:
        result = BinaryToInteger(user_input)
        print(f"The integer value of binary {user_input} is: {result}")
    except ValueError:
        print(f'"{user_input}" is not a valid binary number.')
