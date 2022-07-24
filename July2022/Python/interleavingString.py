@Jiganesh 

# https://leetcode.com/problems/interleaving-string/

class Solution:
    
    # Runtime: 43 ms, faster than 91.15% of Python3 online submissions for Interleaving String.
    # Memory Usage: 15.1 MB, less than 24.82% of Python3 online submissions for Interleaving String.
    

    # TC : O(N+M)
    # SC : O(N) 
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        
        
        dp = {}
        
        def helper(i=0, j=0 , k=0):
            
            
            if i==len(s1) and j == len(s2) and k==len(s3):
                return True
            
            
            if (i, j) in dp : return dp[(i,j)]
            
            ans = False
            if i< len(s1) and k<len(s3) and s1[i]==s3[k]:
                ans = ans or helper(i+1, j , k+1)
                
            if j< len(s2) and k< len(s3) and s2[j]==s3[k]:
                ans = ans or helper(i, j+1 , k+1)
                
            dp[(i,j)] = ans
            return ans
        
        
        return  helper()