// Author: Deepal
// Problem: Rotate Array
// Link: https://leetcode.com/problems/rotate-array/
// Series:
// Category: Medium
// Data structure: Array

import Foundation

class Solution {
    
    func rotate(_ nums: inout [Int], _ k: Int) {
        var k = k
        k %= nums.count
        nums.reverse()
        reverse(&nums, startIndex: 0, endIndex: k - 1)
        reverse(&nums, startIndex: k, endIndex: nums.count - 1)
    }
    
    func reverse(_ nums: inout [Int], startIndex: Int, endIndex: Int) {
        var startIndex = startIndex
        var endIndex = endIndex
        while startIndex < endIndex {
            let temp = nums[startIndex]
            nums[startIndex] = nums[endIndex]
            nums[endIndex] = temp
            startIndex += 1
            endIndex -= 1
        }
    }
}

var array = [1, 2, 3, 4, 5, 6, 7]
Solution().rotate(&array, 3)
print(array)

// TC: O(N)
// SC: O(1)

/*
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/
