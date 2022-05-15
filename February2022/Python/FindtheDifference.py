# TC : O(Max(len(s), len(t)))
# SC : O(1)

class Solution:
    def findTheDifference(self, s: str, t: str) -> str:
        if len(s) == 0:
            return t
        if len(t) == 0:
            return s
        ind = 0
        tSum, sSum = 0, 0
        while ind < len(s) or ind < len(t):
            if ind < len(t):
                tSum += ord(t[ind])
            if ind < len(s):
                sSum += ord(s[ind])
            ind += 1
        return chr(abs(tSum-sSum))
