# TC : O(N)
# SC : O(N)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        map={0:-1}
        maxLen,count=0,0
        for i,val in enumerate(nums):
            if val==0:
                count-=1
            else:
                count+=1
            if count in map:
                maxLen=max(maxLen,i-map[count])
            else:
                map[count]=i
        return maxLen
        