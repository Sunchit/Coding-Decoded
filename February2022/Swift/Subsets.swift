// Author: Deepal
// Problem: Subsets
// Link: https://leetcode.com/problems/subsets/
// Category: Medium
// DataStructure: Array


func subsets(_ nums: [Int]) -> [[Int]] {
    var result = [[Int]]()
    var dataStructure = [Int]()
    helperSubset(index: 0, input: nums, dataStructure: &dataStructure, result: &result)
    return result
}

private func helperSubset(index: Int, input: [Int], dataStructure: inout [Int], result: inout [[Int]]) {
    if index == input.count {
        result.append(dataStructure)
        return
    }
    dataStructure.append(input[index])
    helperSubset(index: index + 1, input: input, dataStructure: &dataStructure, result: &result)
    dataStructure.removeLast()
    helperSubset(index: index + 1, input: input, dataStructure: &dataStructure, result: &result)
}

// TC: (2^NLogn 2 ^ N sorting the array)
// SC: (2^NLogn 2 ^ N sorting the array)

/*
 
 Example 1:
 Input: nums = [1,2,3]
 Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 
 Example 2:
 Input: nums = [0]
 Output: [[],[0]]
 
 */
