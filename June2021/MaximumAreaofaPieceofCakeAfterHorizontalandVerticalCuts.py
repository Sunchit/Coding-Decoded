from math import floor
class Solution:
    # Divide elements into n+1 buckets
    def linear_max_gap(self, arr, _min, _max):
        """
        numer buckets = len(arr) + 1
        bucket size (or range) = (max - min) / number of buckets 
        bucket index for an element = floor((item - min) / bucket size)
        each bucket will have 2 elements only (running max and running min)
        """
        max_gap = 0
        buckets = []
        # Instantiate buckets
        for i in range(len(arr) + 1):
            # All elements of the bucket needn't be stored (only max and min)
            buckets.append([float("inf"), -1])
        bucket_size = (_max-_min) / (len(buckets))
        for item in arr:
            i = floor((item - _min) / bucket_size)
            if item > buckets[i][1]:
                buckets[i][1] = item
            if item < buckets[i][0]:
                buckets[i][0] = item
            else:
                pass # no need of this element
        buckets.append([_max, -1])
        buckets.insert(0, [float("-inf"), _min])
        i = 1
        while i < len(buckets) - 1:
            if (buckets[i][1] == -1 and buckets[i][0] == float("inf")):
                j = i + 1
                while j < len(buckets):
                    if buckets[j][1] != -1 or buckets[j][0] != float("inf"):
                        break
                    j += 1
                max_gap = max(max_gap, buckets[j][0] - buckets[i-1][1])
                i = j # skip to j
                continue
            elif buckets[i+1][0] != inf and buckets[i][1] != -1:
                max_gap = max(max_gap, buckets[i+1][0] - buckets[i][1])
            elif buckets[i-1][1] != -1 and buckets[i][0] != float("inf"):
                max_gap = max(max_gap, buckets[i][0] - buckets[i-1][1])
            i += 1        
        return max_gap
    def maxArea(self, h: int, w: int, horizontalCuts: List[int], verticalCuts: List[int]) -> int:
        # Applying pigenhole to find max_width
        max_width = self.linear_max_gap(horizontalCuts, 0, h)
        max_height = self.linear_max_gap(verticalCuts, 0, w)
        return (max_height * max_width) % (pow(10, 9) + 7)