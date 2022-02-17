# Time Complexity : O(N)
# Space Complexity : O(1)

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        result = 0
        for i in nums:
            result ^= i
        return result
