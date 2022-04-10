// Author: Deepal
// Problem: Single Number
// Link: https://leetcode.com/problems/single-number/
// Category: Eash
// DataStructure: Array

func singleNumber(_ nums: [Int]) -> Int {
    var result = 0
    for item in nums {
        result ^= item
    }
    return result
}

// TC: O(N)
// SC: O(1)

/*
 
 Example 1:
 Input: nums = [2,2,1]
 Output: 1
 
 Example 2:
 Input: nums = [4,1,2,1,2]
 Output: 4
 
 Example 3:
 Input: nums = [1]
 Output: 1
 
 */
