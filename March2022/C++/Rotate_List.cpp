class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head || !head->next) return head;
        ListNode* node=head;
        int size=1;
        while(node->next)
        {
            node=node->next;
            ++size;
        }
        k%=size; if(!k) return head;
        node->next=head;
        ListNode* prev=NULL;
        node=head;int temp=0;
        while(temp!=(size-k))
        {
            prev=node;
            node=node->next;
            ++temp;
        }
        prev->next=NULL;
        ListNode* res=node;
        return res;
    }
};