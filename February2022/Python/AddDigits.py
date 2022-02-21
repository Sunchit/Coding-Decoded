# TC : O(1)
# SC : O(1)

class Solution:
    def addDigits(self, num: int) -> int:
        if num <= 9:
            return num
        if num % 9 == 0:
            return 9
        return num % 9
