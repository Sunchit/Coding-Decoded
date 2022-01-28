// Authoer: Deepal
// Problem: Sequential Digits
// Link: https://leetcode.com/problems/sequential-digits/submissions/
// Category: Medium
// DataStructure: Array
func sequentialDigits(_ low: Int, _ high: Int) -> [Int] {
    let array = [12, 23, 34, 45, 56, 67, 78, 89,
                 123, 234, 345, 456, 567, 678, 789,
                 1234, 2345, 3456, 4567, 5678, 6789,
                 12345, 23456, 34567, 45678, 56789,
                 123456, 234567, 345678, 456789,
                 1234567, 2345678, 3456789,
                 12345678, 23456789,
                 123456789]
    
    var result = [Int]()
    
    for item in array where item >= low && item <= high {
        result.append(item)
    }
    return result
}

// TC: O(1)

/*
 Example 1:
 
 Input: low = 100, high = 300
 Output: [123,234]
 Example 2:
 
 Input: low = 1000, high = 13000
 Output: [1234,2345,3456,4567,5678,6789,12345]
 
 */
