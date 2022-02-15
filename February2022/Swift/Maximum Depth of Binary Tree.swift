// Author: Deepal
// Problem: Maximum Depth of Binary Tree
// Link: https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Category: Easy
// DataStructure: Binary Tree

func maxDepth(_ root: TreeNode?) -> Int {
    var height = 0
    guard let root = root else { return height }
    var queue = Queue<TreeNode>()
    queue.enqueue(root)
    
    while !queue.isEmpty {
        height += 1
        let count = queue.size
        for _ in 0..<count {
            let top = queue.peek!
            
            if let left = top.left {
                queue.enqueue(left)
            }
            
            if let right = top.right {
                queue.enqueue(right)
            }
            queue.dequeue()
        }
    }
    return height
}

// TC: O(N)
// SC: O(N)

/*
 
 Example 1:
 Input: root = [3,9,20,null,null,15,7]
 Output: 3
 
 Example 2:
 Input: root = [1,null,2]
 Output: 2
 
 */
