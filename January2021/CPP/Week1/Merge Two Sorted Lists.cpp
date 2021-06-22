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

//Time: O(n1+n2) Space:O(1)
class Solution
{
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2)
    {

        ListNode *dummyNode = new ListNode(-1);

        ListNode *p = dummyNode;

        //Make more Optimal
        if (l1 == NULL)
        {
            return l2;
        }
        else if (l2 == NULL)
        {
            return l1;
        }

        while (l1 != NULL && l2 != NULL)
        {
            if (l1->val <= l2->val)
            {
                p->next = l1;
                p = l1;
                l1 = l1->next;
            }
            else
            {
                p->next = l2;
                p = l2;
                l2 = l2->next;
            }
        }

        while (l1 != NULL)
        {

            p->next = l1;
            p = l1;
            l1 = l1->next;
        }

        while (l2 != NULL)
        {

            p->next = l2;
            p = l2;
            l2 = l2->next;
        }

        return dummyNode->next;
    }
};