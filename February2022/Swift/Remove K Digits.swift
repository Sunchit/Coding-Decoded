// Author: Deepal
// Problem: Remove K Digits
// Link: https://leetcode.com/problems/minimize-deviation-in-array/
// Category: Mediun
// DataStructure: Stack, Array, String

func removeKdigits(_ num: String, _ k: Int) -> String {
    var stack = Stack<String.Element>()
    let array = Array(num)
    var k = k
    var index = 0
    
    while index < array.count && k > 0 {
        while k > 0 && !stack.isEmpty && array[index].wholeNumberValue! < stack.peek()!.wholeNumberValue! {
            stack.pop()
            k -= 1
        }
        stack.push(array[index])
        index += 1
    }
    
    while !stack.isEmpty && k > 0 {
        stack.pop()
        k -= 1
    }
    
    
    var string = String()
    
    while !stack.isEmpty {
        string = String(stack.pop()!) + string
    }
    
    string = string + String(Array(num)[index...])
    index = 0
    
    let array2 = Array(string)
    
    
    while index < string.count {
        if array2[index] == String.Element("0") {
            index += 1
        } else {
            break
        }
    }
    return String(Array(string)[index...]).count == 0 ? "0" : String(Array(string)[index...])
}

// TC: O(N)
// SC: O(N)

/*
 
 Example 1:
 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 
 Example 2:
 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 
 Example 3:
 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 
 */
