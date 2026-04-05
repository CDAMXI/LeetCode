def hammingWeight(n):
    count = 0
    while n != 0:
        count += n & 1  # Increment if the least significant bit is 1
        n >>= 1         # Shift right by 1 bit
    return count

print(hammingWeight(11))          # Output: 3  (binary: 1011)
print(hammingWeight(128))         # Output: 1  (binary: 10000000)
print(hammingWeight(2147483645))  # Output: 30 (binary: 1111111111111111111111111111101)
