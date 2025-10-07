units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"}
teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"}
tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"}

def IntToString(num):
    if num == 0: return "Zero"
    result = ""
    if num < 0: 
        result += "Minus "
        num*= (-1)
    StringCreator(num, result)
    return result.strip()

def StringCreator(num, result):
    if num >= 1000000000:
        StringCreator(num // 1000000000, result)
        result += "Billion "
        num % 1000000000
    elif num >= 1000000:
        StringCreator(num // 1000000, result)
        result += "Million "
        num % 1000000
    elif num >= 1000:
        StringCreator(num // 1000, result)
        result += "Thousand "
        num % 1000
    elif num >= 100:
        StringCreator(num // 100, result)
        result += str(units[num // 100]) + "Hundred "
        num % 100
    elif num >= 20:
        StringCreator(num // 100, result)
        result += str(tens[num // 10]) +  " "
        num % 10
        num % 100
    elif num >= 10:
        StringCreator(num // 100, result)
        result += str(teens[num // 10]) +  " "
        num % 10
    else:
        StringCreator(num // 100, result)
        result += " "

n = int(input("Put a number: "))
print(f"{n} as text is: {IntToString(n)}")
