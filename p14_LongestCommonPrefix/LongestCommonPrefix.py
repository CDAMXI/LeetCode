def longestCommonPrefix(strs: list[str]) -> str:
    if strs is None or len(strs) == 0:
        return ""
    
    prefix = strs[0]
    for i in range(1, len(strs)):
        while not strs[i].startswith(prefix):
            prefix = prefix[:-1]
            if not prefix:  # Retorna temprano si no hay prefijo común
                return ""
    
    return prefix

strs = ["flower", "flow", "flight"]
print(longestCommonPrefix(strs))

strs1 = ["dog", "racecar", "car"]
print(longestCommonPrefix(strs1))

strs2 = ["florida", "floridaman", "flor"]
print(longestCommonPrefix(strs2))
