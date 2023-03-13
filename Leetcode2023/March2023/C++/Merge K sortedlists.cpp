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
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(!lists.size()) return NULL;
        int len = lists.size();
        while(len>1)
        {
            for(int i=0;i<len/2;i++)
            {
                lists[i]=mergeTwoLists(lists[i],lists[len-1-i]);
            }
            len = (len+1)/2;
        }
        return lists.front();
    }

    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        if(!list1) return list2;
        if(!list2) return list1;
        ListNode* temp ;
        // cout<<list1->val <<" "<<list2->val<<endl;
        if(list1->val < list2->val) 
        {   
            temp=new ListNode(list1->val);
            temp->next = mergeTwoLists(list1->next,list2);
        }
        else
        {
            temp=new ListNode(list2->val);
            temp->next= mergeTwoLists(list1,list2->next);
        }

        return temp;
    }
};