// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
         for (k in matrix.indices) {
             var i = 0
             var j: Int = matrix[0].size - 1
             if (matrix[k][i] <= target || matrix[k][j] >= target) {
                 while (i <= j) {
                     if (matrix[k][i] == target || matrix[k][j] == target) {
                         return true
                     }
                     i++
                     j--
                 }
             }
         }
         return false
     }
 }