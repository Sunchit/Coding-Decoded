// Author: Deepal
// Problem: Swap Nodes in Pairs
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/
// Category: Medium
// DataStructure: LinkedList

// Iterative:

func swapPairs(_ head: ListNode?) -> ListNode? {
    var dummy: ListNode? = ListNode(-1)
    dummy!.next = head
    var currentNode = dummy
    
    while currentNode?.next != nil && currentNode?.next?.next != nil {
        let a = currentNode?.next
        let b = currentNode?.next?.next
        
        a?.next = b?.next
        currentNode?.next = b
        
        currentNode?.next?.next = a
        
        currentNode = currentNode?.next?.next
        
    }
    return dummy?.next
}

// TC: O(N)
// SC: O(1)

// Recursive:

func swapPairs(_ head: ListNode?) -> ListNode? {
    return swapNodes(head)
}

private func swapNodes(_ head: ListNode?) -> ListNode? {
    guard head != nil && head?.next != nil else {
        return head
    }
    let current = head
    let next = head?.next
    current?.next = swapNodes(next?.next)
    next?.next = current
    return next
}

// TC: O(N)
// SC: O(N)

/*
 
 Example 1:
 Input: head = [1,2,3,4]
 Output: [2,1,4,3]
 
 Example 2:
 Input: head = []
 Output: []
 
 Example 3:
 Input: head = [1]
 Output: [1]
 
 */
