def reverse(x: int) -> int:
    is_negative = x < 0
    x = abs(x)
    
    reverse_num = 0
    # Equivalente a Integer.MAX_VALUE / 10 en Java (2147483647 / 10)
    INT_MAX_DIV_10 = 214748364 
    
    while x != 0:
        digit = x % 10
        x //= 10  # División entera
        
        # Comprobar si el próximo paso causará un overflow
        if reverse_num > INT_MAX_DIV_10 or (reverse_num == INT_MAX_DIV_10 and digit > 7):
            return 0  # Retornar 0 si hay overflow
        
        # En esta versión trabajando con absolutos, no necesitamos la 
        # comprobación explícita de Integer.MIN_VALUE, ya que la condición 
        # anterior atrapará correctamente el desbordamiento de los negativos también.
            
        reverse_num = reverse_num * 10 + digit
        
    return -reverse_num if is_negative else reverse_num

if __name__ == "__main__":
    print(reverse(123))          # 321
    print(reverse(-123))         # -321
    print(reverse(120))          # 21
    print(reverse(-2147483648))  # 0
