# TC : NlogNlogM) N--> Number of elements , M --> Maximum Element
# SC : O(N)

class Solution:
    def minimumDeviation(self, nums: List[int]) -> int:
        heap = []
        minimumDeviation = float("inf")
        array_length = len(nums)

        for num in nums:
            if num % 2 == 0:
                heappush(heap, -num)
            else:
                heappush(heap, -num*2)

        minVal = -max(heap)

        while True:
            maxVal = -heappop(heap)
            minimumDeviation = min(minimumDeviation, maxVal-minVal)

            if maxVal % 2:
                break

            heappush(heap, -maxVal//2)
            minVal = min(minVal, maxVal//2)

        return minimumDeviation
