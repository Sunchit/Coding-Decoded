// Problem: 4Sum II
// Link: https://leetcode.com/problems/4sum-ii/
// Category: Medium
// DataStructure: Array

func fourSumCount(_ nums1: [Int], _ nums2: [Int], _ nums3: [Int], _ nums4: [Int]) -> Int {
    var dictionary = [Int: Int]()
    
    for i in 0..<nums1.count {
        for j in 0..<nums2.count {
            let sumAB = nums1[i] + nums2[j]
            dictionary[sumAB] = dictionary[sumAB, default: 0] + 1
        }
    }
    var answer = 0
    for i in 0..<nums3.count {
        for j in 0..<nums4.count {
            let sumCD = nums3[i] + nums4[j]
            let sumAB = -(sumCD)
            answer += dictionary[sumAB] ?? 0
        }
    }
    return answer
}

// TC: O(n^2)
// SC: O(n^2)

/*
 
 Example 1:
 Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
 Output: 2
 Explanation:
 The two tuples are:
 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
 
 Example 2:
 Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
 Output: 1
 
 */
