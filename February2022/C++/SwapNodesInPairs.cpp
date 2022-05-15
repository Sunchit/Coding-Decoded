
// @saorav21994


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
        
        if (head == NULL || head->next == NULL) return head;
        
        ListNode* prev = head;
        ListNode* cur = head->next;
        
        head = cur;
        
        while (true) {
            ListNode* nxt = cur->next;
            cur->next = prev;
            
            if (nxt == NULL || nxt->next == NULL) {
                prev->next = nxt;
                break;
            }
            
            prev->next = nxt->next;
            
            prev = nxt;
            cur = prev->next;
        }
        
        return head;
    }
};
