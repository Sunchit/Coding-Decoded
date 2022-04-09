// Author: Deepal
// Problem: Excel Sheet Column Number
// Link: https://leetcode.com/problems/excel-sheet-column-number/
// Category: Easy
// DataStructure: String, HashMap

func titleToNumber(_ columnTitle: String) -> Int {
    var result = 0
    let map = getCharMap()
    var factorial = 1
    
    for (_, element) in columnTitle.enumerated().reversed() {
        let string = String(element)
        result += factorial * map[string]!
        factorial *= 26
    }
    return result
}

private func getCharMap() -> [String: Int] {
    var map = [String: Int]()
    let startIndex = Unicode.Scalar("A").value
    let endIndex = Unicode.Scalar("Z").value
    
    for (index, element) in (startIndex...endIndex).enumerated() {
        let char = String(Unicode.Scalar(element)!)
        map[char] = index + 1
    }
    return map
}

// TC: O(N)
// SC: O(1)

/*

Example 1:
Input: columnTitle = "A"
Output: 1

Example 2:
Input: columnTitle = "AB"
Output: 28

Example 3:
Input: columnTitle = "ZY"
Output: 701

*/