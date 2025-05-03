def calculateLetterInSpanish(n):
    if len(n) != 8: raise ValueError("The number must be 8 digits long")
    if not n.isdigit(): raise ValueError("The number must be numeric")
    letters = "TRWAGMYFPDXBNJZSQVHLCKE"
    remainder = int(n) % 23
    return n + letters[remainder]

try:
    n = input("Enter an 8-digit number: ")
    result = calculateLetterInSpanish(n)
    print(f"The complete ID is: {result}")
except ValueError as e:
    print(e)
