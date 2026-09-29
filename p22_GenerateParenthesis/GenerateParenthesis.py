def generateParenthesis(n):
    """
    Generate all combinations of well-formed parentheses.

    :param n: Number of pairs of parentheses
    :return: List of strings representing valid combinations
    """
    def backtrack(s, left, right):
        if len(s) == 2 * n:
            result.append(s)
            return
        if left < n:
            backtrack(s + '(', left + 1, right)
        if right < left:
            backtrack(s + ')', left, right + 1)

    result = []
    backtrack('', 0, 0)
    return result

print("For 1: " + str(generateParenthesis(1)) + "\n")
print("For 2: " + str(generateParenthesis(2)) + "\n")
print("For 3: " + str(generateParenthesis(3)) + "\n")
