@Jiganesh

# https://leetcode.com/problems/max-area-of-island/

from typing import List
class Solution:
    
    # Runtime: 136 ms, faster than 95.11% of Python3 online submissions for Max Area of Island.
    # Memory Usage: 16.6 MB, less than 47.65% of Python3 online submissions for Max Area of Island.

    # Time Complexity: O(m*n)
    # Space Complexity: O(N) Recursion Stack Space
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        
        
        R = len(grid)
        C = len(grid[0])
        
        
        def helper (i, j):
            
            if valid(i,j):
                grid[i][j]= -1 # to keep track that we have traversed it
                return 1 + helper(i+1, j) + helper(i-1, j) + helper(i, j+1) + helper(i, j-1)
                
            return 0
        
        def valid (i, j):
            return 0<=i<R and 0<=j<C and grid[i][j]==1
            
        max_area = 0
        
        for i in range (R):
            for j in range (C):
                
                if grid[i][j]==1:
                    curr_area = helper(i, j)
                    max_area  = max(max_area, curr_area)
                        
        return max_area
    
