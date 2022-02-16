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
    ListNode* swapPairs(ListNode* head) {
        if(!head || !head->next) return head;

        ListNode* temp=NULL,*res=head->next;
        ListNode* first=head,*second=head->next;;
        
        while(first && second)
        {
            temp=second->next;
            second->next=first;
            first->next=temp && temp->next?temp->next:temp;
            first=temp;
            second=first?first->next:first;
        }
        
        return res;
        
    }
    
};
