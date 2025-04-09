def IntegerToBinary(n):
    """
    Convert an integer to its binary representation.
    
    Args:
        n (int): The integer to convert.
        
    Returns:
        str: The binary representation of the integer.
    """
    if n < 0:
        raise ValueError("Input must be a non-negative integer.")
    
    if n == 0:
        return "0"
    
    binary = ""
    while n > 0:
        binary = str(n % 2) + binary
        n //= 2
    
    return binary

while True:
    try:
        n = int(input("Enter a non-negative integer (or -1 to exit): "))
        if n == -1:
            break
        print(f"Binary representation of {n} is: {IntegerToBinary(n)}")
    except ValueError as e:
        print(e)
    except Exception as e:
        print("An unexpected error occurred:", e)
