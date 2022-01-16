
# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)
# TC : O(N)
# SC : O(N)

class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        result = 0
        curr = 0
        for ind in range(len(seats)):
            if seats[ind] != 1:
                curr += 1
                result = max(result, (curr+1)//2)
            else:
                curr = 0
        for ind in range(len(seats)):
            if seats[ind] == 1:
                result = max(result, ind)
                break
        for ind in range(len(seats)-1, -1, -1):
            if seats[ind] == 1:
                result = max(result, len(seats)-ind-1)
                break
        return result
