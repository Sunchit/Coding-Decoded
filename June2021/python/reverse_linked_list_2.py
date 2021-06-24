# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head, left, right):
        
        node_val = []
        temp = head
        
        left -=1
        right -=1
        
        c = 0
        
        while c != right + 1:     
            if c >= left and c <=right:
                node_val.append(temp.val)
            c+=1
            temp = temp.next
            
        c2 = 0
        temp_2 = head
        
        while c2 != right+1:
            if c2 >= left and c2 <=right:
                temp_2.val = node_val.pop(-1)
            c2+=1
            temp_2 = temp_2.next
            
        return head