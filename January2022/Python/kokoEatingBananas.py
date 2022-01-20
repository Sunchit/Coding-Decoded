# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(Nlog(M)),Where,M-->Max element in an array
# SC : O(1)

class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        low = 1
        high = max(piles)
        ans = 0
        while low <= high:
            mid = (low+high)//2
            if(self.eatPossible(piles, h, mid)):
                ans = mid
                high = mid-1
            else:
                low = mid+1
        return ans

    def eatPossible(self, piles, h, k):
        count = 0
        for val in piles:
            if val <= k:
                count += 1
            else:
                count = count+val//k
                if val % k:
                    count += 1
        return count <= h
