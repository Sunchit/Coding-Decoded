# TC : O(N)
# SC : O(1)

class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        columnNumber = 0
        for ind in range(len(columnTitle)):
            currCharPos = ord(columnTitle[ind])-64
            columnNumber *= 26
            columnNumber += currCharPos
        return columnNumber
