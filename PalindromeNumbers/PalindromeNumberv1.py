def isPalindrome(num):
    if num < 0 or (num % 10 == 0 and num != 0): return False
    revertNum = 0
    while num > revertNum:
        revertNum = revertNum * 10 + num % 10
        num //= 10
    return num == revertNum or num == revertNum / 10

print(isPalindrome(55))
print(isPalindrome(12))
print(isPalindrome(120))
print(isPalindrome(120021))
