def addBinary(bin1, bin2):
    if(detectBase(bin1) != "Detected base: 2"):
        bin1 = bin(bin1)
    if(detectBase(bin2) != "Detected base: 2"):
        bin2 = bin(bin2)
    
    sum_bin = bin(int(bin1, 2) + int(bin2, 2))
    return sum_bin[2:]

def detectBase(n):
    if n.startswith("0b"):
        base = 2
    elif n.startswith("0o"):
        base = 8
    elif n.startswith("0x"):
        base = 16
    else:
        base = 10

    return f"Detected base: {base}"

if __name__ == "__main__":
    bin1 = int(input("Enter first binary number: "))
    bin2 = int(input("Enter second binary number: "))
    
    result = addBinary(bin1, bin2)
    print(f"Sum of {bin1} and {bin2} is: {result}")
