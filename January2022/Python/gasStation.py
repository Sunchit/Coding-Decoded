# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(1)


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1
        total = 0
        start = 0
        for ind in range(len(gas)):
            total += gas[ind]-cost[ind]
            if total < 0:
                total = 0
                start = ind+1
        return start
