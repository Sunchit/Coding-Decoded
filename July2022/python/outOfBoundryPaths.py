@Jiganesh

# https://leetcode.com/problems/out-of-boundary-paths/]

class Solution:
    
    # TC : O(maxMoves) 
    # SC : O(N) # Cache
    
    # Runtime: 156 ms, faster than 73.91% of Python3 online submissions for Out of Boundary Paths.
    # Memory Usage: 19.3 MB, less than 37.34% of Python3 online submissions for Out of Boundary Paths.
    
    def findPaths(self, m: int, n: int, maxMove: int, startRow: int, startColumn: int) -> int:
        
        def valid(x, y):
            return 0<= x< m and 0<=y<n
        
        dp = {}
        MOD = (10**9)+7
        
        def helper(x, y , N):
            
            if not valid(x, y): return 1
             
            if N<=0 : return 0
            
            if (x, y, N) in dp : return dp[(x, y, N)]
            
            ans = helper(x-1, y, N-1)+ helper(x+1, y, N-1) + helper(x, y-1, N-1)+ helper(x, y+1, N-1)
            dp[(x, y, N)] = ans % MOD
            
            return dp[(x, y, N)]
        
        return helper(startRow, startColumn, maxMove)
        
