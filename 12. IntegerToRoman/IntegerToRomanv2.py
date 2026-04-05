def int_to_roman(number: int) -> str:
    value_map = [
        (1000, "M"), (900, "CM"), (500, "D"), (400, "CD"),
        (100, "C"),  (90, "XC"), (50, "L"),  (40, "XL"),
        (10, "X"),   (9, "IX"),  (5, "V"),   (4, "IV"), (1, "I")
    ]
    result = []
    for value, numeral in value_map:
        count, number = divmod(number, value)
        result.append(numeral * count)
    return ''.join(result)

def is_valid_integer(s: str) -> bool:
    return s.isdigit() and 0 < int(s) <= 3999

def main():
    while True:
        num = input("Enter an integer (1–3999) (or 'exit' to quit): ").strip()
        if num.lower() == "exit":
            print("Goodbye!")
            break
        if is_valid_integer(num):
            roman = int_to_roman(int(num))
            print(f"The Roman numeral of {num} is: {roman}")
        else:
            print("Invalid input. Please enter a number between 1 and 3999.")

if __name__ == "__main__":
    main()
