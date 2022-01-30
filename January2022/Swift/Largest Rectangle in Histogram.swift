// Author: Deepal
// Problem: Largest Rectangle in Histogram
// Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
// Category: Hard
// DataStructure: Stack

struct Stack<Element> {
    private var storage = [Element]()
    func peek() -> Element? { storage.last }
    mutating func push(_ element: Element) { storage.append(element)  }
    @discardableResult mutating func pop() -> Element? { storage.popLast() }
    mutating func empty() { storage.removeAll() }
    var isEmpty: Bool { return storage.isEmpty }
}


func largestRectangleArea(_ heights: [Int]) -> Int {
    guard !heights.isEmpty else { return 0 }
    
    let count = heights.count
    
    var leftSpan = [Int](repeating: 0, count: count)
    var rightSpan = [Int](repeating: 0, count: count)
    
    var stack = Stack<Int>()
    
    for index in 0..<count {
        while !stack.isEmpty && heights[index] <= heights[stack.peek()!] {
            stack.pop()
        }
        
        if stack.isEmpty {
            leftSpan[index] = -1
        } else {
            leftSpan[index] = stack.peek() ?? 0
        }
        stack.push(index)
    }
    
    stack.empty()
    
    for index in stride(from: count - 1, to: -1, by: -1) {
        while !stack.isEmpty && heights[index] <= heights[stack.peek()!] {
            stack.pop()
        }
        
        if stack.isEmpty {
            rightSpan[index] = count
        } else {
            rightSpan[index] = stack.peek() ?? 0
        }
        stack.push(index)
    }
    
    var maxResult = 0
    
    for index in 0..<count {
        let area = (rightSpan[index] - leftSpan[index] - 1) * heights[index]
        maxResult = max(area, maxResult)
    }
    return maxResult
}

// TC: O(N)
// SC: O(N)

let largestRectangleAreaOutput = largestRectangleArea([2, 1, 5, 6, 2, 3])
print(largestRectangleAreaOutput)
print("###")
