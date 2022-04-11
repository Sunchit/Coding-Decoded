// Author: Deepal
// Problem: Subarray Sum Equals K
// Link: https://leetcode.com/problems/subarray-sum-equals-k/
// Category: Medium
// DataStructure: Array

func subarraySum(_ nums: [Int], _ k: Int) -> Int {
    var count = 0
    var dictionary = [Int: Int]()
    dictionary[0] = 1
    var sum = 0
    
    for element in nums {
        sum += element
        if let item = dictionary[sum - k] {
            count += item
        }
        dictionary[sum] = dictionary[sum, default: 0] + 1
        
    }
    return count
}

// TC: O(N)
// SC: O(N)

/*
 
 Example 1:
 Input: nums = [1,1,1], k = 2
 Output: 2
 
 Example 2:
 Input: nums = [1,2,3], k = 3
 Output: 2
 
 */
