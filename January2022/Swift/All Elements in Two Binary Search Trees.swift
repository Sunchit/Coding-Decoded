// Author: Deepal
// Problem: All Elements in Two Binary Search Trees
// Link: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
// Category: Medium
// DataStructure: Binary Search Tree

func getAllElements(_ root1: TreeNode?, _ root2: TreeNode?) -> [Int] {
    var result1 = [Int]()
    var result2 = [Int]()
    inOrderTraverse(root: root1, result: &result1)
    inOrderTraverse(root: root2, result: &result2)
    let result = mergeTwoArray(array1: &result1, array2: &result2)
    return result
}

private func inOrderTraverse(root: TreeNode?, result: inout [Int]) {
    if root != nil {
        inOrderTraverse(root: root?.left, result: &result)
        result.append(root?.val ?? 0)
        inOrderTraverse(root: root?.right, result: &result)
    }
}

private func mergeTwoArray(array1: inout [Int], array2: inout [Int]) -> [Int] {
    var result = [Int](repeating: 0, count: array1.count + array2.count)
    
    var index1 = 0
    var index2 = 0
    var index3 = 0
    
    while index1 < array1.count && index2 < array2.count {
        if array1[index1] < array2[index2] {
            result[index3] = array1[index1]
            index3 += 1
            index1 += 1
        } else {
            result[index3] = array2[index2]
            index3 += 1
            index2 += 1
        }
    }
    
    while index1 < array1.count {
        result[index3] = array1[index1]
        index3 += 1
        index1 += 1
    }
    
    while index2 < array2.count {
        result[index3] = array2[index2]
        index3 += 1
        index2 += 1
    }
    return result
}

// TC: O(M+N) 
// SC: O(M+N)

let allElementsInTwoBSTOutput = Solution().getAllElements(TreeNode(2, TreeNode(1), TreeNode(4)),
                                                          TreeNode(1, TreeNode(0), TreeNode(3)))
print(allElementsInTwoBSTOutput)
