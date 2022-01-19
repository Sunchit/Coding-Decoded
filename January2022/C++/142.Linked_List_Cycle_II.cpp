class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode* slow=head,*fast=head;
        while(fast && slow<=fast)
        {
            fast=fast->next;
            if(fast && fast<=slow) return fast;
            else fast=fast?fast->next:fast;
            slow=slow->next;
        }
        return fast;
    }
};