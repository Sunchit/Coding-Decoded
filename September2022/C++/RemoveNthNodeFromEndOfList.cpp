// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* p1 = head;
        ListNode* p2 = head;
        
        while (n > 0) {
            p1 = p1->next;
            if (p1 == NULL) {   // it means we have to delete the first node
                return head->next;
            }
            n--;
        }
        
        while (p1->next != NULL) {
            p1 = p1->next;
            p2 = p2->next;
        }
        
        p2->next = p2->next->next;
        return head;
    }
};
