# TC : O(NlogN)
# SC : O(N)

class Solution:
    def findPairs(self, nums: List[int], k: int) -> int:
        resultSet = set()
        length = len(nums)
        nums.sort()
        for ind in range(len(nums)-1):
            pairInd = self.findPairInd(nums, ind, length-1, k)
            if pairInd >= 0:
                print(nums[ind], nums[pairInd])
                pair = (nums[ind], nums[pairInd])
                if pair not in resultSet:
                    resultSet.add(pair)
        return len(resultSet)

    def findPairInd(self, nums, l, r, k):
        curr = nums[l]
        l = l+1
        while l <= r:
            mid = (l+r)//2
            currDiff = abs(nums[mid]-curr)
            if currDiff == k:
                return 1
            elif currDiff > k:
                r = mid-1
            else:
                l = mid+1
        return -1
