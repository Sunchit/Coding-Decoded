# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(nlogn)
# SC : O(1)

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x: x[0])
        arrowCount = 0
        x = points[0][1]
        for i in range(1, len(points)):
            if points[i][0] <= x:
                x = min(points[i][1], x)
            else:
                arrowCount += 1
                x = points[i][1]
        return arrowCount+1
