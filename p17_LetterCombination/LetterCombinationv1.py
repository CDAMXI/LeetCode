def letterCombinations(digits):
    result = []
    if len(digits) == 0:
        return result
    findCombinations(digits, 0, "", result)
    return result

def findCombinations(digits, index, combination, result):
    if index == len(digits):
        result.append(combination)
        return
    letters = getLetters(digits[index])
    for ch in letters:
        findCombinations(digits, index + 1, combination + ch, result)

def getLetters(letter):
    mapping = {
        '2': "abc", '3': "def", '4': "ghi",
        '5': "jkl", '6': "mno", '7': "pqrs",
        '8': "tuv", '9': "wxyz"
    }
    return mapping.get(letter, "")

print(f"For {23}, the solution is {letterCombinations("23")}")
print(f"For {2}, the solution is {letterCombinations("2")}")
