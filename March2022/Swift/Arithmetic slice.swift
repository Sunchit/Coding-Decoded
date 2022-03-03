// Author: Deepal
// Problem: Arithmetic Slices
// Link: https://leetcode.com/problems/arithmetic-slices/
// Category: Medium
// DataStructure: Array

func numberOfArithmeticSlices(_ nums: [Int]) -> Int {
    guard nums.count > 2 else { return 0 }
    
    var previousCount = 0
    var total = 0
    
    for index in 2..<nums.count {
        if nums[index] - nums[index - 1] == nums[index - 1] - nums[index - 2] {
            previousCount += 1
        } else {
            previousCount = 0
        }
        total += previousCount
    }
    return total
    }

// TC: O(N)
// SC: O(1)

/*
 
 Example 1:
 Input: nums = [1,2,3,4]
 Output: 3
 Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 
 Example 2:
 Input: nums = [1]
 Output: 0
 
 */
