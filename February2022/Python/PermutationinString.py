# TC : O(len1+(len2-len1)*26)
# SC : O(26)

class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        len1 = len(s1)
        len2 = len(s2)
        if len1 > len2:
            return False
        freq = [0 for i in range(26)]
        for ind in range(len1):
            freq[ord(s1[ind])-ord('a')] += 1
            freq[ord(s2[ind])-ord('a')] -= 1
        if self.allZero(freq):
            return True
        for ind in range(len1, len2):
            rightCharInd = ord(s2[ind])-ord('a')
            freq[rightCharInd] -= 1
            leftCharInd = ord(s2[ind-len1])-ord('a')
            freq[leftCharInd] += 1
            if self.allZero(freq):
                return True
        return False

    def allZero(self, freq):
        for val in freq:
            if val != 0:
                return False
        return True
