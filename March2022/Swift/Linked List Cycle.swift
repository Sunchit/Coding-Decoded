// Author: Deepal
// Problem: Linked List Cycle
// Link: https://leetcode.com/problems/linked-list-cycle/
// Category: Easy
// DataStructure: LinkedList

func hasCycle(_ head: ListNode?) -> Bool {
    var slow = head
    var fast = head
    
    repeat {
        slow = slow?.next
        fast = fast?.next?.next
        
        if fast == nil {
            return false
        }
    } while slow === fast //ObjectIdentifier(slow!) != ObjectIdentifier(fast!)
    return true
}

// TC: O(N)
// TC: O(1)

/*
 
 Example 1:
 Input: head = [3,2,0,-4], pos = 1
 Output: true
 Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 
 Example 2:
 Input: head = [1,2], pos = 0
 Output: true
 Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 
 Example 3:
 Input: head = [1], pos = -1
 Output: false
 Explanation: There is no cycle in the linked list.
 
 */
