# TC : O(N)
# SC : O(1)

class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        if len(nums) <= 1:
            return len(nums)
        currPtr = 1
        currValOccurence = 1
        currVal = nums[0]
        k = 1
        for ind in range(1, len(nums)):
            if nums[ind] != currVal:
                nums[currPtr] = nums[ind]
                currVal = nums[ind]
                currPtr += 1
                currValOccurence = 1
                k += 1
            else:
                if currValOccurence < 2:
                    nums[currPtr] = nums[ind]
                    currVal = nums[ind]
                    currPtr += 1
                    k += 1
                currValOccurence += 1
        return k
