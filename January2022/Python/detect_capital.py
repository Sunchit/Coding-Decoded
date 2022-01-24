# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(1)

class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        cap, small = 0, 0
        for ch in word:
            if ch.isupper():
                cap += 1
            else:
                small += 1
        if (cap == 1 and word[0].isupper()) or cap == len(word) or small == len(word):
            return True
        return False
