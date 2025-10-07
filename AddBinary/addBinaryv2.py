def detect_base(s: str) -> int:
    """Return 2/8/16 if prefixed (0b/0o/0x), else 10."""
    s = s.strip()
    if s.startswith(("0b", "0B")):
        return 2
    if s.startswith(("0o", "0O")):
        return 8
    if s.startswith(("0x", "0X")):
        return 16
    return 10

def to_int(s: str) -> int:
    """Parse string s in its detected base into an int."""
    s = s.strip()
    base = detect_base(s)
    # Remove prefix for bases 2/8/16 so int() no se queje con base explícita
    if base in (2, 8, 16):
        s = s[2:]
    return int(s, base)

def add_binary(a: str, b: str) -> str:
    """Add two numbers given as strings (in 2/8/10/16) and return binary (no '0b')."""
    total = to_int(a) + to_int(b)
    return bin(total)[2:]

if __name__ == "__main__":
    print("=== Binary Adder ===")
    print("You can input numbers like 0b1011, 0o17, 0x1A, or decimal (e.g., 25).")
    x = input("Enter first number: ")
    y = input("Enter second number: ")

    try:
        result = add_binary(x, y)
        print(f"Sum (binary): {result}")
    except ValueError as e:
        print("Invalid input. Please check the number and its base prefix (0b/0o/0x).")
