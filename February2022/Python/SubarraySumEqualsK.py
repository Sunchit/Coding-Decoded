# TC : O(N)
# SC : O(N)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sumOccurenceMap = {0: 1}
        prefixSum, count = 0, 0
        for ind in range(len(nums)):
            prefixSum += nums[ind]
            if prefixSum-k in sumOccurenceMap:
                count += sumOccurenceMap[prefixSum-k]
            if prefixSum not in sumOccurenceMap:
                sumOccurenceMap[prefixSum] = 0
            sumOccurenceMap[prefixSum] += 1
        return count
