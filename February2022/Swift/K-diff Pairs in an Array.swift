// Author: Deepal
// Problem: K-diff Pairs in an Array
// Link: https://leetcode.com/problems/k-diff-pairs-in-an-array/
// Category: Medium
// DataStructure: Array

class Solution {
    func findPairs(_ nums: [Int], _ k: Int) -> Int {
        guard !nums.isEmpty && k >= 0 else { return 0 }
        
        var dictionary = [Int: Int]()
        var count = 0
        for item in nums {
            dictionary[item, default: 0] += dictionary[item, default: 1]
        }
        
        for (key, value) in dictionary {
            if k == 0 {
                if value >= 2 {
                    count += 1
                }
            } else if let _ = dictionary[key + k] {
                count += 1
            }
        }
        return count
    }
}

// TC: O(N)
// SC: O(N)

/*
 
 Example 1:
 Input: nums = [3,1,4,1,5], k = 2
 Output: 2
 Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 Although we have two 1s in the input, we should only return the number of unique pairs.
 
 Example 2:
 Input: nums = [1,2,3,4,5], k = 1
 Output: 4
 Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 
 Example 3:
 Input: nums = [1,3,1,5,4], k = 0
 Output: 1
 Explanation: There is one 0-diff pair in the array, (1, 1).
 
 */
