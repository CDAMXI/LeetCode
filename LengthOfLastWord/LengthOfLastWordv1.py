def lengthOfLastWord(s):
    s = s.strip()  # elimina espacios al principio y final
    length = 0
    i = len(s) - 1
    
    while i >= 0 and s[i] != ' ':
        length += 1
        i -= 1
    
    return length

s = input("Put a text (it may contain spaces): ")
print(f'The size of the last word in "{s}" is {lengthOfLastWord(s)}')
