# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(N)
# SC : O(N)

class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        largest = 0
        ind = 0
        stack = []
        while ind < len(heights):
            if not stack or heights[stack[-1]] <= heights[ind]:
                stack.append(ind)
                ind += 1
            else:
                peekInd = stack.pop()
                area = (heights[peekInd] *
                        ((ind - stack[-1] - 1) if stack else ind))
                largest = max(area, largest)
        while stack:
            peekInd = stack.pop()
            area = (heights[peekInd] *
                    ((ind - stack[-1] - 1) if stack else ind))
            largest = max(area, largest)
        return largest
