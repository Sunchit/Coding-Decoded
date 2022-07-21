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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        
        if(!head) return head;
        
        vector<int> v;
        ListNode* h1 = head;
        while(h1)
        {  
            v.push_back(h1->val);
            h1 = h1 -> next;
        }

        reverse(v.begin()+left-1, v.begin()+right);
        
        ListNode* ans = new ListNode(0);
        ListNode* cur = ans;

        for(int i=0;i<v.size();i++)
        {
            ListNode* temp = new ListNode(0);
            temp->val = v[i];
            cur -> next = temp;
            cur = cur ->next;
        }
        return ans->next;
        
    }
};
