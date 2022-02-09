// Author: Deepal
// Problem: Add Digits
// Link: https://leetcode.com/problems/add-digits/
// Category: Easy
// DataStructure: String

private func helperAddDigits(_ num: Int) -> Int {
    var num = num
    var result = 0
    
    while num != 0 {
        result += num % 10
        num /= 10
    }
    return result
}

private func helperAddDigitsString(_ num: Int) -> Int {
    var result: Int = 0
    let string: String = num.description + ""
    
    for item in string {
        result += Int(String(item))!
    }
    return Int(result)
}

func addDigits(_ num: Int) -> Int {
    var result = num
    while true {
        result = helperAddDigitsString(result)
        if result < 10 {
            break
        }
    }
    return result
}

// TC: O(Log N)
// SC: O(1)

///////////////////////////////////////////////

func addDigits(_ num: Int) -> Int {
    if num == 0 { return 0 }
    return num % 9 == 0 ? 9 : num % 9
}

// TC: O(1)
// SC: O(1)

/*
 
 Example 1:
 Input: num = 38
 Output: 2
 Explanation: The process is
 38 --> 3 + 8 --> 11
 11 --> 1 + 1 --> 2
 Since 2 has only one digit, return it.
 
 Example 2:
 Input: num = 0
 Output: 0
 
 */
