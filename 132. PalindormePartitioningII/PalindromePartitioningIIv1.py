def minCut(s):
    n = len(s)
    dp = [0] * n
    for i in range(n):
        dp[i] = i

    # Use center expansion to find all palindromic substrings and update dp
    for center in range(2 * n - 1):
        left = center // 2
        right = left + center % 2

        # Expand while characters are equal
        while left >= 0 and right < n and s[left] == s[right]:
            if left == 0:
                # If the palindrome starts at index 0, no cuts are needed
                dp[right] = 0
            else:
                # Update the minimum number of cuts for this position
                dp[right] = min(dp[right], dp[left - 1] + 1)

            # Move the pointers outward
            left -= 1
            right += 1

    return dp[n - 1]


def main():
    test_cases = ["aab", "a", "ab", "bb", "abbab", "abcba", "abacaba"]

    for s in test_cases:
        print(f'{s} → {minCut(s)}')


# Entry point
if __name__ == "__main__":
    main()
