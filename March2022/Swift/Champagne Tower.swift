// Author: Deepal
// Problem: Champagne Tower
// Link: https://leetcode.com/problems/champagne-tower/
// Category: Medium
// DataStructure: Array

func champagneTower(_ poured: Int, _ query_row: Int, _ query_glass: Int) -> Double {
    var q = Array<[Double]>(repeating: Array<Double>(repeating: 0, count: 102), count: 102)
    q[0][0] = Double(poured)
    for r in 0...query_row {
        for c in 0...r {
            let val = (q[r][c] - 1)/2
            if val > 0 {
                q[r+1][c] += val
                q[r+1][c+1] += val
            }
        }
    }
    return min(1.0, q[query_row][query_glass])
}

// TC: O(N)
// SC: O(N)

/*
 
 Example 1:
 Input: poured = 1, query_row = 1, query_glass = 1
 Output: 0.00000
 Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.
 
 Example 2:
 Input: poured = 2, query_row = 1, query_glass = 1
 Output: 0.50000
 Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
 
 Example 3:
 Input: poured = 100000009, query_row = 33, query_glass = 17
 Output: 1.00000
 
 */
