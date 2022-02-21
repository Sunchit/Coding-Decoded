# TC : O(NlogN)
# Sc : O(1)

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        nums.sort()
        prev = nums[0]
        count = 1
        length = len(nums)
        if length <= 2:
            return nums[0]
        for ind in range(1, length):
            if nums[ind] == prev:
                count += 1
                if count > length//2:
                    return nums[ind]
            else:
                count = 1
                prev = nums[ind]
