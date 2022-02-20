# TC : O(NlogN)
# Sc : O(1)

class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        intervals.sort(key=lambda x:x[0])
        count=1
        start=intervals[0][0]
        end=intervals[0][1]
        for ind in range(1,len(intervals)):
            if intervals[ind][0]>start and intervals[ind][1]>end:
                count+=1
            if intervals[ind][1]>end:
                start=intervals[ind][0]
                end=intervals[ind][1]
                
        return count
        
        