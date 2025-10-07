def isPalindrome(s):
    i, j = 0, len(s) - 1
    s = s.lower()
    
    while i <= j:
        # Skip non-alphanumeric characters on the left
        while i < j and not s[i].isalnum():
            i += 1

        # Skip non-alphanumeric characters on the right
        while i < j and not s[j].isalnum():
            j -= 1
        
        if s[i] != s[j]: return False
        i+=1
        j -= 1
        
        return True
    
s = input("Give me a text: ")
if not isPalindrome(s): print(f"\"{s}\" is NOT a palindrome.")
else: print(f"\"{s}\" is INDEED a palindrome.")
