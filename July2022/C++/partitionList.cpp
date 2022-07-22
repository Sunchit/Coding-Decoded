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
    ListNode* partition(ListNode* head, int x) {
        
        if(!head or !head->next) return head;
        
        ListNode* ans = new ListNode(0);
        ListNode* cur = head;
        ListNode* nextHead = NULL;
        ListNode* temp1 = ans;
        ListNode* temp2 = NULL;

        while(cur)
        {
            if(cur->val<x)
            {
                temp1->next = cur;
                temp1 = temp1->next;
            }
            else
            {
                if(temp2==NULL)
                {
                    nextHead = cur;
                    temp2 = cur;
                }
                else 
                {
                    temp2->next = cur;
                    temp2 = temp2->next;
                }
            }
            cur = cur -> next;
        }
        temp1->next = nextHead;
        if(temp2!=NULL) temp2->next = NULL;
        return ans->next;
    }
};
