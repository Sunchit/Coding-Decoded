class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        if(!head || !head->next) return head;
        
        ListNode* anchor=new ListNode(-1) , *newhead=anchor,*prev=NULL,*curr=head,*next=head->next;
        while(curr)
        {
            if(
                ((prev && next) && (prev->val!=curr->val && curr->val!=next->val))
            ||  ((!prev && next) && (curr->val!=next->val)) 
            ||  ((!next && prev) && (prev->val!=curr->val))  
            )
            {
                
                anchor->next=curr;
                anchor=anchor->next;
                anchor->next=NULL;
                
            }
            prev=curr;
            curr=next;
            next=next?next->next:next;
            
        }
        return newhead->next;
    }
};