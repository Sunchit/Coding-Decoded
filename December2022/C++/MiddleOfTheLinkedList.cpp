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

// Author: @mvssgupta

class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        ListNode* slowPtr = head , *fastPtr = head;
        while(fastPtr && fastPtr->next)   
        {
            slowPtr = slowPtr->next;
            fastPtr = fastPtr->next->next;
        }
        return slowPtr;
    }
};
