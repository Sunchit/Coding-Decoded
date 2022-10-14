# https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
# Author : @Jiganesh 

from typing import Optional

# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
        
class Solution:
    def deleteMiddle(self, head: Optional[ListNode]) -> Optional[ListNode]:

        dummyNode = ListNode(-1)
        dummyNode.next = head
        
        prev = dummyNode
        slow = fast = head

        while fast and fast.next:
            prev, slow, fast = slow, slow.next , fast.next.next

        prev.next = slow.next
        return dummyNode.next
