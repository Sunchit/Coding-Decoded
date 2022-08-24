class Solution {
private:
    ListNode* reverse(ListNode* root) {
        ListNode* prev = NULL;
        ListNode* curr = root;
        
        while (curr != NULL) {
            ListNode* next = curr->next;
            curr->next = prev;            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
public:
    // TC: O(n)
    // SC: O(1)
    bool isPalindrome(ListNode* head) {
        ListNode* fast = head;
        ListNode* slow = head;
        
        while (fast != NULL && fast->next != NULL) {
            slow = slow->next;
            fast = fast->next->next;            
        }
        
        if (fast != NULL) { // it means there are odd nodes in the linked-list
            slow = slow->next;
        }
        
        slow = reverse(slow);
        fast = head;
        
        while (slow != NULL) {
            if (fast->val != slow->val) {
                return false;
            }
            fast = fast->next;
            slow = slow->next;
        }
                
        return true;
    }
};
