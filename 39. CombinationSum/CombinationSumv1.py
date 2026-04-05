def combinationSum(candidates, target):
    result = []
    combinationSumHelper(candidates, target, 0, [], result)
    return result

def combinationSumHelper(candidates, remaining, start, current, result):
    if remaining == 0:
        result.append(list(current))
        return

    for i in range(start, len(candidates)):
        if candidates[i] > remaining:
            continue  # skip if number too large
        current.append(candidates[i])
        combinationSumHelper(candidates, remaining - candidates[i], i, current, result)
        current.pop()

if __name__ == "__main__":
    candidates = [2, 3, 6, 7]
    target = 7
    print(combinationSum(candidates, target))
