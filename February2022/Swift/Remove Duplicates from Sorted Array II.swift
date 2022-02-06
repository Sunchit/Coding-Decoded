// Author: Deepal
// Problem: Remove Duplicates from Sorted Array II
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
// Category: Medium
// DataStructure: Array

func removeDuplicates(_ nums: inout [Int]) -> Int {
    var endIndex = 0
    var oIndex = 0
    
    while endIndex < nums.count {
        let startIndex = endIndex
        
        while endIndex < nums.count - 1 && nums[endIndex] == nums[endIndex + 1] {
            endIndex += 1
        }
        
        var frequency = min(2, endIndex - startIndex + 1)
        
        while frequency > 0 {
            nums[oIndex] = nums[startIndex]
            oIndex += 1
            frequency -= 1
        }
        endIndex += 1
    }
    return oIndex
}

// TC: O(N)
// SC: O(1)

/*
 
 Example 1:
 Input: nums = [1,1,1,2,2,3]
 Output: 5, nums = [1,1,2,2,3,_]
 Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 
 Example 2:
 Input: nums = [0,0,1,1,1,1,2,3,3]
 Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 It does not matter what you leave beyond the returned k (hence they are underscores).
 
 */
