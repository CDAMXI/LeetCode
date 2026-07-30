def lengthOfLongestSubstring(s: str) -> int:
    char_set = set()
    max_length = 0
    left = 0

    for right in range(len(s)):
        char = s[right]
        
        # If the character is already in the set, shrink the window from the left
        while char in char_set:
            char_set.remove(s[left])
            left += 1
            
        # Add the current character to the set
        char_set.add(char)
        
        # Update the maximum length found so far
        max_length = max(max_length, right - left + 1)

    return max_length

# --- Main execution ---
if __name__ == "__main__":
    print(lengthOfLongestSubstring("abcabcbb"))  # Expected Output: 3
