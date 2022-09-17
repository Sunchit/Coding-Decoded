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
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* prev=new ListNode(-1);
        prev->next=head;
        ListNode* node=head;
        head=prev;
        while(node)
        {
            if(node->val==val)
            {
                prev->next=node->next;
                delete node;
            }
            else
                prev=node;
            node=prev->next;
        }
        return head->next;
    }
};