# TC : O(N^2)

class Solution:
    def fourSumCount(self, nums1: List[int], nums2: List[int], nums3: List[int], nums4: List[int]) -> int:
        map = defaultdict(int)
        count = 0
        for val1 in nums1:
            for val2 in nums2:
                map[val1+val2] += 1
        for val1 in nums3:
            for val2 in nums4:
                sum = -(val1+val2)
                if sum in map:
                    count += map[sum]
        return count
