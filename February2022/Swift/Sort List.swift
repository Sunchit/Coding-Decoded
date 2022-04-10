// Author: Deepal
// Problem: Sort List
// Link: https://leetcode.com/problems/sort-list/
// Category: Medium
// DataStructure: LinkedList

func sortList(_ head: ListNode?) -> ListNode? {
    if head == nil || head?.next == nil {
        return head
    }
    
    var pre: ListNode? = nil
    var slow: ListNode? = head
    var fast: ListNode? = head
    
    while fast != nil && fast?.next != nil {
        pre = slow
        slow = slow?.next
        fast = fast?.next?.next
    }
    pre?.next = nil
    let l1 = sortList(head)
    let l2 = sortList(slow)
    
    return merge(l1, l2)
}

private func merge(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
    let dummy = ListNode(0)
    var l1 = l1
    var l2 = l2
    var cur: ListNode? = dummy
    
    while l1 != nil && l2 != nil {
        if l1!.val < l2!.val {
            cur?.next = l1
            l1 = l1?.next
        } else {
            cur?.next = l2
            l2 = l2?.next
        }
        cur = cur?.next
    }
    if l1 != nil {
        cur?.next = l1
    }
    if l2 != nil {
        cur?.next = l2
    }
    
    return dummy.next
}

// TC: O(N log N)
// SC: O(1)

/*
 
 Example 1:
 Input: head = [4,2,1,3]
 Output: [1,2,3,4]
 
 Example 2:
 Input: head = [-1,5,3,4,0]
 Output: [-1,0,3,4,5]
 
 Example 3:
 Input: head = []
 Output: []
 
 */
