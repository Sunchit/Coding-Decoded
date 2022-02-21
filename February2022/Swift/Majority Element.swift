// Author: Deepal
// Problem: Majority Element
// Link: https://leetcode.com/problems/majority-element/
// Category: Easy
// DataStructure: Array

func majorityElement(_ nums: [Int]) -> Int {
    guard !nums.isEmpty else { return 0 }
    var map = [Int: Int]()
    for item in nums {
        map[item, default: 0] += 1
    }
    var maxKey = 0
    var maxValue = 0
    for (key, value) in map {
        if value >= nums.count / 2 && value > maxValue {
            maxKey = key
            maxValue = value
        }
    }
    return maxKey
}

// TC: O()
// SC: O(1)

func majorityElement(_ nums: [Int]) -> Int {
    var majorityElement = nums[0]
    var majorityElementCount = 1
    
    for index in 1..<nums.count {
        if nums[index] == majorityElement { 
            majorityElementCount += 1   
        } else {
            majorityElementCount -= 1
            if majorityElementCount == 0 {
                majorityElement = nums[index]
                majorityElementCount = 1
            }
        }
    }
    return majorityElement
}

// SC: O(N)
// SC: O(1)

/*
 
 Example 1:
 Input: nums = [3,2,3]
 Output: 3
 
 Example 2:
 Input: nums = [2,2,1,1,1,2,2]
 Output: 2
 
 */
