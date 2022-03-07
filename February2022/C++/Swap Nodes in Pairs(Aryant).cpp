Brief note about Question-

We have to swap every two adjacent nodes and return its head.
Let's take an example not given in question -
Suppose our head pointer given to us as [1,9,2,8,3,7]

So, we have to swap every two adjcant nodes,
the answer should be [9,1,8,2,7,3]
Solution - I (using recursion, Accepted)-

The very basic thing that is given to us is, it is given in form of linked list.

We have a advantage by having linked list, How?

For swapping every two adjcant nodes, we will be able to just change the link of nodes.

See how we change links on the first example.
I have mention everything in image itself, and also add comment in code also, but if u have still doubt or suggestion,please put that in comment part.

Code (C++)

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        // if head is NULL OR just having a single node, then no need to change anything 
        if(head == NULL || head -> next == NULL) 
        {
            return head;
        }
            
        ListNode* temp; // temporary pointer to store head -> next
        temp = head->next; // give temp what he want
        
        head->next = swapPairs(head->next->next); // changing links
        temp->next = head; // put temp -> next to head
        
        return temp; // now after changing links, temp act as our head
    }
};