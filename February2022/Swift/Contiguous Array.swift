// Author: Deepal
// Problem:
// Link: https://leetcode.com/problems/contiguous-array/
// Category: Medium
// DataStructure: Array

func findMaxLength(_ nums: [Int]) -> Int {
    guard !nums.isEmpty else { return 0 }
    var dictionary = [Int: Int]()
    dictionary[0] = -1
    var prefixSum = 0
    var maxCount = 0
    
    for index in 0..<nums.count {
        prefixSum = prefixSum + (nums[index] == 0 ? -1 : 1)
        
        if let currentValue = dictionary[prefixSum] {
            if maxCount < index - currentValue {
                maxCount = index - currentValue
            }
        } else {
            dictionary[prefixSum] = index
        }
    }
    return maxCount
}

// TC: O(N)
// SC: O(N)

/*
 Example 1:
 Input: nums = [0,1]
 Output: 2
 Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 
 Example 2:
 Input: nums = [0,1,0]
 Output: 2
 Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 
 */
