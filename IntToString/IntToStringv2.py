units = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
teens = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
tens  = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

def three_digits_to_words(n: int) -> str:
    """Convierte un número 0..999 a palabras en inglés."""
    parts = []
    if n >= 100:
        parts.append(units[n // 100])
        parts.append("Hundred")
        n %= 100
    if 10 <= n <= 19:
        parts.append(teens[n - 10])
        n = 0
    elif n >= 20:
        parts.append(tens[n // 10])
        n %= 10
    if 0 < n < 10:
        parts.append(units[n])
    return " ".join(parts).strip()

def IntToString(num: int) -> str:
    if num == 0:
        return "Zero"
    sign = "Minus " if num < 0 else ""
    num = abs(num)

    parts = []

    billions = num // 1_000_000_000
    if billions:
        parts.append(three_digits_to_words(billions))
        parts.append("Billion")
    num %= 1_000_000_000

    millions = num // 1_000_000
    if millions:
        parts.append(three_digits_to_words(millions))
        parts.append("Million")
    num %= 1_000_000

    thousands = num // 1_000
    if thousands:
        parts.append(three_digits_to_words(thousands))
        parts.append("Thousand")
    num %= 1_000

    if num:
        parts.append(three_digits_to_words(num))

    return (sign + " ".join(parts)).strip()

# Demo
if __name__ == "__main__":
    n = int(input("Put a number: "))
    print(f"{n} as text is: {IntToString(n)}")
