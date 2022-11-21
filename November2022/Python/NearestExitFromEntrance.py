

# https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
# Author : @Jiganesh

from typing import List
from collections import deque

class Solution:

    # TC : O(M*N)
    # SC : O(M*N)
    
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        R = len(maze)
        C = len(maze[0])

        directions = [(-1, 0), (1, 0), (0, -1), (0, 1)] # up, down, left, right
        
        self.ans = float("inf")

        def isvalid (i, j):
            return 0<=i<R and 0<=j<C and maze[i][j]== "."

        # BFS
        def helper(i, j, steps):

            queue = deque([(i,j,steps)])
            visited = set()
            while queue:
                i, j, steps = queue.popleft()

                if not isvalid(i,j):
                    continue

                if (i==0 or i==R-1 or j==0 or j==C-1) and [i,j] != entrance and maze[i][j]==".":
                    return steps

                for x, y in directions:
                    ix = x+i
                    jy = y+j
                    if (ix, jy) not in visited:
                        visited.add((ix, jy))
                        queue.append((ix, jy, steps+1))
            
            return -1

        i, j = entrance
        return helper(i, j , 0)
        