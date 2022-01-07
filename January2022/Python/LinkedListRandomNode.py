#Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

'''
        Approach 1  
        TC : O(1)
        SC : O(n)
'''

class Solution:
    import random
    def __init__(self, head: Optional[ListNode]):
        self.array=[]
        while head:
            self.array.append(head.val)
            head=head.next
        

    def getRandom(self) -> int:
        return random.choice(self.array)
       
'''
####### Approach 2 ###### 
        TC : O(n)
        SC : O(1)
'''
class Solution:
    def __init__(self, head: Optional[ListNode]):
        self.head=head
        
    def getRandom(self) -> int:
        reservoir=self.head.val
        i=1
        curr=self.head
        while curr:
            if random.random()<1/i:
                reservoir=curr.val
            i+=1
            curr=curr.next
        return reservoir
        
