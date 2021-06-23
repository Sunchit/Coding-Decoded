#Author-Aditya Chauhan
#fast,single pass,In place reversal

#Problem link-https://leetcode.com/problems/reverse-linked-list-ii

class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        if not head or left==right:
            return head
        lol=ListNode(0)
        lol.next=head
        prev=lol
        curr=lol.next
        c=1
        while curr:
            if c>=left and c<=right-1:
                n=curr.next
                curr.next=curr.next.next
                n.next=prev.next
                prev.next=n
                c+=1
            else:
                prev=curr
                curr=curr.next
                c+=1
        
        return  lol.next
