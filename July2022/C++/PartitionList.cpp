class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    ListNode* partition(ListNode* head, int x) {
        ListNode* dummy1 = new ListNode(0); // this will store numbers less than x
        ListNode* temp1 = dummy1;
        
        ListNode* dummy2 = new ListNode(0); // this will store numbers greater than x
        ListNode* temp2 = dummy2;
        
        while (head != NULL) {
            if (head->val < x) {
                dummy1->next = head;
                dummy1 = dummy1->next;
            } else {
                dummy2->next = head;
                dummy2 = dummy2->next;
            }
            head = head->next;
        }
        
        dummy2->next = NULL;    // to avoid cycle in linked-list
        dummy1->next = temp2->next;
        
        return temp1->next;
    }
};
