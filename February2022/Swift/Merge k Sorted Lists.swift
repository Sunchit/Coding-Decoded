// Author: Deepal
// Problem: Merge k Sorted Lists
// Link: https://leetcode.com/problems/merge-k-sorted-lists/
// Category: Hard
// DataStructure: LinkedList

func mergeKLists(_ lists: [ListNode?]) -> ListNode? {
    guard !lists.isEmpty else { return nil }
    return helper(lists: lists, low: 0, high: lists.count - 1)
}

private func helper(lists: [ListNode?], low: Int, high: Int) -> ListNode? {
    if low > high {
        return nil
    } else if low == high {
        return lists[low]
    } else {
        let mid = low + (high - low) / 2
        let left = helper(lists: lists, low: low, high: mid)
        let right = helper(lists: lists, low: mid + 1, high: high)
        return mergeLinkedList(l1: left, l2: right)
    }
}

private func mergeLinkedList(l1: ListNode?, l2: ListNode?) -> ListNode? {
    if l1 == nil {
        return l2
    }
    
    if l2 == nil {
        return l1
    }
    
    let dummy: ListNode? = ListNode(-1)
    var result: ListNode? = dummy
    var node1 = l1
    var node2 = l2
    
    while node1 != nil && node2 != nil {
        if node1!.val < node2!.val {
            result!.next = node1
            result = result!.next
            node1 = node1!.next
        } else {
            result!.next = node2
            result = result!.next
            node2 = node2!.next
        }
    }
    
    while node1 != nil {
        result!.next = node1
        result = result!.next
        node1 = node1!.next
    }
    
    while node2 != nil {
        result!.next = node2
        result = result!.next
        node2 = node2!.next
    }
    return dummy!.next
}


/*
 
 Example 1:
 Input: lists = [[1,4,5],[1,3,4],[2,6]]
 Output: [1,1,2,3,4,4,5,6]
 Explanation: The linked-lists are:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 merging them into one sorted list:
 1->1->2->3->4->4->5->6
 
 Example 2:
 Input: lists = []
 Output: []
 Example 3:
 
 Input: lists = [[]]
 Output: []
 
 */
