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
class Solution
{
public:
    //TC:O(N)| SC:O(1)
    ListNode *deleteDuplicates(ListNode *head)
    {
        ListNode *dummyNode = new ListNode(INT_MIN);

        dummyNode->next = head;
        ListNode *curr = head;
        ListNode *prev = dummyNode;

        while (curr != NULL && curr->next != NULL)
        {

            bool duplication = false;
            while (curr != NULL && curr->next != NULL && curr->val == curr->next->val)
            {
                duplication = true;
                curr = curr->next;
            }

            if (!duplication)
            {
                prev = prev->next;
            }
            else
            {
                prev->next = curr->next;
            }
            curr = curr->next;
        }

        return dummyNode->next;
    }
};