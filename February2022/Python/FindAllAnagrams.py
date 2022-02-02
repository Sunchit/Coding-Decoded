# TC : O(N)
# SC : O(26) --> O(1)

class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        sLen, pLen = len(s), len(p)
        if sLen < pLen:
            return []
        result = []
        hash = [0 for i in range(26)]
        left, right, count = 0, 0, pLen
        for ch in p:
            ind = ord(ch)-97
            hash[ind] += 1
        while right < sLen:
            currChar = s[right]
            if hash[ord(currChar)-97] >= 1:
                count -= 1
            hash[ord(currChar)-97] -= 1
            right += 1
            if count == 0:
                result.append(left)
            if right-left == pLen:
                leftChar = s[left]
                if hash[ord(leftChar)-97] >= 0:
                    count += 1
                hash[ord(leftChar)-97] += 1
                left += 1
        return result
