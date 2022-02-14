# TC : O(N*2^N)
# TC : O(N*2^N)

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsetList = []
        subsetList = self.findSubset(0, nums, [], [])
        return subsetList

    def findSubset(self, index, nums, temp, subsetList):
        if index == len(nums):
            subsetList.append(list(temp))
            return
        temp.append(nums[index])
        self.findSubset(index+1, nums, temp, subsetList)
        temp.pop()
        self.findSubset(index+1, nums, temp, subsetList)
        return subsetList
