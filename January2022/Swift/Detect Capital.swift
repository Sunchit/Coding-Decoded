// Problem: Detect Capital
// Link: https://leetcode.com/problems/detect-capital/
// Category: Easy
// DataStructure: Array


func detectCapitalUse(_ word: String) -> Bool {
    guard word.count > 1 else { return true }
    let array = Array(word)
    if array[0].isUppercase {
        let firstLetter = array[1].isUppercase
        for index in 2..<array.count {
            let currentLetter = array[index].isUppercase
            if firstLetter != currentLetter {
                return false
            }
        }
    } else {
        for index in 0..<array.count {
            if array[index].isUppercase {
                return false
            }
        }
    }
    return true
}

// TC: O(N)
// SC: O(1)

/*
 Example 1:
 
 Input: word = "USA"
 Output: true
 Example 2:
 
 Input: word = "FlaG"
 Output: false
 */
