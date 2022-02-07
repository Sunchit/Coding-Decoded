// Author: Deepal
// Problem: Find the Difference
// Link: https://leetcode.com/problems/find-the-difference/
// Category: Easy
// DataStructure: String

func findTheDifference(_ s: String, _ t: String) -> Character {
    var c: UInt8 = 0
    
    for char in s {
        c ^= char.asciiValue!
    }
    
    for char in t {
        c ^= char.asciiValue!
    }
    
    return Character(UnicodeScalar(c))
}

// TC: O(N)
// SC: O(1)

/*
 
 Example 1:
 Input: s = "abcd", t = "abcde"
 Output: "e"
 Explanation: 'e' is the letter that was added.
 
 Example 2:
 Input: s = "", t = "y"
 Output: "y"
 
 */
