#Author :  Karthik K ( https://www.linkedin.com/in/karthikmunirathinam/ )

# TC : O(n*m*m)
# SC : O(n*m*m)

class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        n=len(grid)
        m=len(grid[0])
        dp=[[[0]*m for i in range(m)] for j in range(n)]
        return self.dfs(grid,n,m,0,0,m-1,dp)
    def dfs(self,grid,n,m,r,col1,col2,dp):
        if r<0 or r>=n or col1<0 or col1>=m or col2<0 or col2>=m:
            return 0
        if dp[r][col1][col2]!=0:
            return dp[r][col1][col2]
        maxCherries=0
        for i in range(-1,2):
            for j in range(-1,2):
                newCol1=col1+i
                newCol2=col2+j
                maxCherries=max(maxCherries,self.dfs(grid,n,m,r+1,newCol1,newCol2,dp))
                
        if col1==col2:
            currCherry=grid[r][col1]
        else:
            currCherry=grid[r][col1]+grid[r][col2]
        dp[r][col1][col2]=currCherry+maxCherries
        return dp[r][col1][col2]
        
        