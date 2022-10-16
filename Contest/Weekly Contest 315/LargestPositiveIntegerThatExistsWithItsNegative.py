# https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/
# Author : @Jiganesh

from typing import List

class Solution:

    # TC : O(N)
    # SC : O(N)
    def findMaxK(self, nums: List[int]) -> int:
        
        lookup = set(nums)

        result = float("-inf")
        for num in nums:
            if -num in lookup:
                result = max(result, num)

        return result if result != float("-inf") else -1
 