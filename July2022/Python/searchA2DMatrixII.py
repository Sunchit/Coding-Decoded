@ Jiganesh
# https://leetcode.com/problems/search-a-2d-matrix-ii/

from typing import List



class Solution:

    # TC : O(m*n)
    # SC : O(1)
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        
        row , col = 0, len(matrix[0])-1
        while row<len(matrix) and  col>=0:
        
            pointing = matrix[row][col]
            if pointing == target : return True
            if pointing > target: col-=1
            else : row+=1
                
        return False