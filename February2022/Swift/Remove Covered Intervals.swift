// Author: Deepal
// Problem:  Remove Covered Intervals
// Link: https://leetcode.com/problems/remove-covered-intervals/
// Category: Medium
// DataStructure: Array

func removeCoveredIntervals(_ intervals: [[Int]]) -> Int {
    let array = intervals.sorted {
        return $0[0] == $1[0] ? $0[1] > $1[1] : $0[0] < $1[0]
    }
    var removedCount = 0
    var minValue = -1
    
    for item in array {
        if item[1] > minValue {
            minValue = item[1]
            removedCount += 1
        }
    }
    return removedCount
}

// T(N)
// S(1)

/*
 
 Example 1:
 Input: intervals = [[1,4],[3,6],[2,8]]
 Output: 2
 Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
 
 Example 2:
 Input: intervals = [[1,4],[2,3]]
 Output: 1
 
 */
