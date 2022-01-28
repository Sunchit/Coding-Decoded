// Author: Deepal
// Problem: Valid Mountain Array
// Link: https://leetcode.com/problems/valid-mountain-array/
// Category: Easy
// DataStructure: Array

func validMountainArray(_ arr: [Int]) -> Bool {
    guard !arr.isEmpty else { return false }
    
    var index = 0
    while index < arr.count - 1 {
        if arr[index] < arr[index + 1] {
            
        } else {
            break
        }
        index += 1
    }
    
    if index == 0 || index == arr.count - 1 { return false }
    
    while index < arr.count - 1 {
        if arr[index] > arr[index + 1] {
            
        } else {
            break
        }
        index += 1
    }
    return index == arr.count - 1
}

// TC: O(N)
// SC: O(1)
/*
 Example 1:
 Input: arr = [2,1]
 Output: false
 
 Example 2:
 Input: arr = [3,5,5]
 Output: false
 
 Example 3:
 Input: arr = [0,3,2,1]
 Output: true
 */
