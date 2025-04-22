def CheckIfRomanNumeral(num):
    romanChars = {'I', 'V', 'X', 'L', 'C', 'D', 'M'}
    
    # Checks if all characters in 'num' are valid Roman numeral characters
    return all(char in romanChars for char in num.upper())

def RomanNumeralToArabianNums(num):
    num = num.upper()  # Ensures the Roman numeral is uppercase
    
    # Dictionary mapping Roman characters to their values
    roman_to_Arabian = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
    
    valor = 0
    length = len(num)
    
    # Iterate through the Roman numeral
    for i in range(length):
        char1 = num[i]
        
        # If not the last character, compare with the next one
        if i + 1 < length:
            char2 = num[i + 1]
            # If current value is less than next one, subtract
            if roman_to_Arabian[char1] < roman_to_Arabian[char2]:
                valor -= roman_to_Arabian[char1]
            else:
                valor += roman_to_Arabian[char1]
        else:
            # If it's the last character, just add its value
            valor += roman_to_Arabian[char1]
    
    return valor

def ArabianToRomanNumeral(num):
    # List of (Arabian_value, roman_symbol) pairs
    Arabian_to_roman = [
        (1000, 'M'), (900, 'CM'), (500, 'D'), (400, 'CD'),
        (100, 'C'), (90, 'XC'), (50, 'L'), (40, 'XL'),
        (10, 'X'), (9, 'IX'), (5, 'V'), (4, 'IV'), (1, 'I')
    ]
    
    roman_numeral = ""
    
    # Iterate through each pair (Arabian, roman)
    for value, roman in Arabian_to_roman:
        # While the number is greater than or equal to the current value
        while num >= value:
            roman_numeral += roman  # Add the Roman numeral
            num -= value  # Subtract the value from the number
    
    return roman_numeral

def isArabianNum(num):
    # Checks if all characters are digits
    return num.isdigit()

# Main loop
while True:
    num = input("Enter a value (or 'exit' to exit): ").strip()
    
    if num.lower() == "exit":
        print("Goodbye!")
        break
    
    if CheckIfRomanNumeral(num):
        result = RomanNumeralToArabianNums(num)
        print(f"The Arabian value of {num} is: {result}")
    elif isArabianNum(num):
        num = int(num)  # Convert to integer before passing to the function
        result = ArabianToRomanNumeral(num)
        print(f"The Roman numeral of {num} is: {result}")
    else:
        print("Invalid input. Please enter a valid Roman or Arabian numeral.")
