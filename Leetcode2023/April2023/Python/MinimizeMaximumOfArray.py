class Solution:
    def minimizeArrayValue(self, nums: List[int]) -> int:
        start = 1
        end = -sys.maxsize - 1
        
        for it in nums:
            end = max(end, it)
        
        ans = 0
        
        while start <= end:
            mid = start + (end - start) // 2
            isPossible = self.helper(nums, mid)
            
            if isPossible:
                ans = mid
                end = mid - 1
            else:
                start = mid + 1
        
        return ans
    
    def helper(self, nums: List[int], expectedMax: int) -> bool:
        n = len(nums)
        arr = nums.copy()
        
        for i in range(n - 1):
            if arr[i] > expectedMax:
                return False
            
            buffer = expectedMax - arr[i]
            arr[i + 1] -= buffer
        
        return arr[n - 1] <= expectedMax
