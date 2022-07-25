@Jiganesh

# https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

from typing import List
class Solution:
    
    # Runtime: 126 ms, faster than 54.16% of Python3 online submissions for Find First and Last Position of Element in Sorted Array.
    # Memory Usage: 15.4 MB, less than 93.21% of Python3 online submissions for Find First and Last Position of Element in Sorted Array.
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        if not nums: return [-1, -1]
        
        def binarysearchleft (nums):
            start = 0
            end = len(nums)
            
            while start < end:
                mid = start + (end-start) //2
                if nums[mid] < target:
                    start = mid+1
                else :
                    end = mid
            return start
                    
        def binarysearchright (nums):
            start = 0
            end = len(nums)

            while start < end:
                mid = start + (end-start)//2
                
                if nums[mid] <= target:
                    start = mid+1
                else :
                    end = mid
            return start-1
        
        left = binarysearchleft(nums)
        right = binarysearchright(nums)

        
        answer = [-1,-1]
        if 0<=left<len(nums) and nums[left]==target : answer[0]=left
        if 0<=right<len(nums) and nums[right]==target : answer[1]=right
        
        return answer