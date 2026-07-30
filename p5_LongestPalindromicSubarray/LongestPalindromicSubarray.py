def longestPalindrome(s):
    if s is None or len(s) < 1:
        return ""
    start, end = 0, 0
    for i in range(len(s)):
        len1 = expandFromCenter(s, i, i)
        len2 = expandFromCenter(s, i, i+1)
        maxLen = max(len1, len2)
        
        if maxLen > (end - start):
            start = i - (maxLen - 1) // 2
            end = i + maxLen // 2
            
    return s[start:end+1]

def expandFromCenter(s, left, right):
    # Corrección: 'right < len(s)' para evitar el IndexError
    while left >= 0 and right < len(s) and s[left] == s[right]:
        left -= 1
        right += 1
    return right - left - 1

print(f"For abccba, the longest palindromic subarray is: {longestPalindrome('abccba')}")
