
# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

class Solution:
    def wordPattern(self, pattern: str, s: str) -> bool:
        d1 = defaultdict(list)
        d2 = defaultdict(list)
        s = s.split()
        if len(s) != len(pattern):
            return False
        for i in range(len(s)):
            d1[pattern[i]] += [s[i]]
        for i in range(len(s)):
            d2[s[i]] += [pattern[i]]
        for key in d1.keys():
            if len(set(d1[key])) > 1:
                return False
        for key in d2.keys():
            if len(set(d2[key])) > 1:
                return False
        return True
