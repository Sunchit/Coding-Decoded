/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    void reorderList(ListNode* head) {
        if(!head->next || !head->next->next) return ;
        ListNode* prev=NULL,*slow=head,*fast=head;
        while(fast && fast->next)
        {
            prev=slow;
            slow=slow->next;
            fast=fast->next->next;
        }
        
        prev->next=NULL;
        slow=reverse(slow);
        
        merge(head,slow);
        
    }
    ListNode* reverse(ListNode* node)
    {
        ListNode* curr=node;
        ListNode* prev=NULL,*nextnode=node->next;
        while(curr)
        {
            curr->next=prev;
            prev=curr;
            curr=nextnode;
            nextnode=nextnode?nextnode->next:nextnode;
        }
        return prev;
        
    }
    
    void merge(ListNode* l1,ListNode* l2)
    {
        ListNode* n1,*n2;
        while(l1 && l2)
        {
            n1=l1->next;n2=l2->next;
            l1->next=l2;
            if(!n1) return ;
            l2->next=n1;
            l1=n1;
            l2=n2;
        }
    }
};