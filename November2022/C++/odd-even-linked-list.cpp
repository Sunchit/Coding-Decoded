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
        
        if(head == NULL){
            return head;
        }
        
        ListNode* odd = head;
        ListNode*even = head->next;
        ListNode* prev = head->next;
        
        while(even!=NULL && even->next != NULL){
            
            odd->next = even->next;
            
            if(odd->next != NULL){
            odd = odd->next;
            }
            
            if(even-> next!=NULL){
            even -> next = even->next->next;
            even = even->next;
            }
        }
        
        odd->next = prev;
        
        return head;
        
    }
};