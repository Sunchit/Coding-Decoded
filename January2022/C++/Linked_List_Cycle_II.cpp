created by @Pranav108
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        auto p = head;
        auto q = head;
        bool notFound = true;
        while(p&&q&&q->next&&notFound){
            p = p->next;
            q = q->next->next;
            if(p == q)
                notFound = false;
        }
        if(notFound) return NULL;
        p = head;
        while(p != q){
            p = p->next;
            q = q->next;
        }
        return p;
    }
};
