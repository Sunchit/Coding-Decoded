// Author: Deepal
// Problem: Pairs of Songs with Total Durations Divisible by 60
// Link: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
// Category: Medium
// DataStructure: Array

func numPairsDivisibleBy60(_ time: [Int]) -> Int {
    var output = 0
    var array = [Int](repeating: 0, count: 60)
    
    for item in time {
        let remainder = item % 60
        array[remainder] += 1
    }
    
    for index in 1..<30 {
        // m * n
        output += array[index] * array[60 - index]
    }
    
    // Below are special cases
    
    // Only make a pair with it self if value > 1
    
    if array[0] > 0 {
        // n * (n - 1) / 2
        output += array[0] * (array[0] - 1) / 2
    }
    
    // Only make a pair with it self if value > 1
    
    if array[30] > 0 {
        output += array[30] * (array[30] - 1) / 2
    }
    return output
}

let numPairsDivisibleBy60Input = [30, 20, 150, 100, 40]
let numPairsDivisibleBy60Output = numPairsDivisibleBy60(numPairsDivisibleBy60Input)
print(numPairsDivisibleBy60Output)

/*
 Example 1:
 
 Input: time = [30,20,150,100,40]
 Output: 3
 Explanation: Three pairs have a total duration divisible by 60:
 (time[0] = 30, time[2] = 150): total duration 180
 (time[1] = 20, time[3] = 100): total duration 120
 (time[1] = 20, time[4] = 40): total duration 60
 Example 2:
 
 Input: time = [60,60,60]
 Output: 3
 Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 
 
 Constraints:
 
 1 <= time.length <= 6 * 104
 1 <= time[i] <= 500
 */
