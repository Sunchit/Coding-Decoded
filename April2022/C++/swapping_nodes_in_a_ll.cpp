
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
//https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
class Solution {
public:
    ListNode* swapNodes(ListNode* head, int k) {
         ListNode *xprev=NULL,*x=head,*y=head,*yprev=NULL,*fast=head;
        ListNode *curr=head;
        int cnt=k-1;
        // pointer setting
        while(cnt--)
        {
            xprev=fast;
            fast = fast->next;
        }
        x=fast;
        while(fast->next!=NULL)
        {
            yprev = y;
            y = y->next;
            fast=fast->next;
        }
        // setting previous
        if(xprev==NULL)
        {
            head=y;
        }
        else{
            xprev->next = y;
        }
        if(yprev==NULL){
            head=x;
        }
        else{
            yprev->next=x;
        }
        
        //swaping actual nodes;
        ListNode* temp = x->next;
        x->next = y->next;
        y->next = temp;
        return head;
    }
};
