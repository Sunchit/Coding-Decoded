@Jiganesh

# https://leetcode.com/problems/partition-list/

from typing import Optional
# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    # Runtime: 49 ms, faster than 61.47% of Python3 online submissions for Partition List.
    # Memory Usage: 14 MB, less than 31.57% of Python3 online submissions for Partition List.
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        
        smallerNode, largerNode = ListNode(-1), ListNode(-1)
        smallerPointer , largerPointer = smallerNode, largerNode
        current= head
        
        while current :
            
            nextNode = current.next
            current.next = None
            
            if current.val >=x :
                largerPointer.next = current
                largerPointer = largerPointer.next

            else:
                smallerPointer.next =current
                smallerPointer = smallerPointer.next

            current = nextNode
        
        smallerPointer.next = largerNode.next
        return smallerNode.next
            
