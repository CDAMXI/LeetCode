def is_match(s: str, p: str) -> bool:
    m, n = len(s), len(p)
    dp = [[False] * (n + 1) for _ in range(m + 1)]

    dp[0][0] = True  # empty string matches empty pattern

    # Initialize dp for patterns like a*, a*b*, a*b*c*, etc.
    for j in range(2, n + 1):
        if p[j - 1] == '*' and dp[0][j - 2]:
            dp[0][j] = True

    # Fill DP table
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            sc = s[i - 1]
            pc = p[j - 1]

            if pc == '.' or pc == sc:
                dp[i][j] = dp[i - 1][j - 1]
            elif pc == '*':
                prev = p[j - 2]
                dp[i][j] = dp[i][j - 2] or ((prev == '.' or prev == sc) and dp[i - 1][j])

    return dp[m][n]

if __name__ == "__main__":
    print(f'For s = "aab", p = "c*a*b", isMatch(s, p) = {is_match("aab", "c*a*b")}')
    print(f'For s = "mississippi", p = "mis*is*p*." isMatch(s, p) = {is_match("mississippi", "mis*is*p*.")}')
