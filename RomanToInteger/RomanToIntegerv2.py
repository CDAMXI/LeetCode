def roman_to_int(roman: str) -> int:
    roman = roman.upper()
    roman_map = {'I': 1, 'V': 5, 'X': 10, 'L': 50,
                 'C': 100, 'D': 500, 'M': 1000}
    total = 0
    prev = 0
    for char in reversed(roman):
        val = roman_map.get(char, 0)
        if val < prev:
            total -= val
        else:
            total += val
            prev = val
    return total

def is_valid_roman(s: str) -> bool:
    return all(c in 'IVXLCDM' for c in s.upper())

def main():
    while True:
        roman = input("Enter a Roman numeral (or 'exit' to quit): ").strip()
        if roman.lower() == "exit":
            print("Goodbye!")
            break
        if is_valid_roman(roman):
            arabian = roman_to_int(roman)
            print(f"The integer value of {roman} is: {arabian}")
        else:
            print("Invalid Roman numeral.")

if __name__ == "__main__":
    main()
