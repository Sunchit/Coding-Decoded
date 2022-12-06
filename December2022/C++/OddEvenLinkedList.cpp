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
    ListNode* oddEvenList(ListNode* head) {
        if(head==nullptr) return head;
        ListNode *d1=head,*d2=head->next,*d=head->next;
        while(d2 && d2->next)
        {
            d1->next = d1->next->next;
            d1 = d1->next;
            d2->next = d2->next->next;
            d2 = d2->next;
        }
        d1->next = d;
        return head;
    }
};