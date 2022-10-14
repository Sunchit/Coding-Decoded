# https://leetcode.com/problems/delete-node-in-a-linked-list/
# Author: Jiganesh Patil

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    
    # TC : O(N)
    # SC : O(1)
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        prev = None
        while node.next:
            node.val = node.next.val
            prev = node
            node = node.next
        prev.next = None
        
    
    # TC : O(1)
    # SC : O(1)
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next