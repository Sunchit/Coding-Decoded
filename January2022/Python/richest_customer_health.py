# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(1)

class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        maxWealth = 0
        for row in accounts:
            currWealth = 0
            for col in row:
                currWealth += col
            maxWealth = currWealth if currWealth > maxWealth else maxWealth
        return maxWealth
