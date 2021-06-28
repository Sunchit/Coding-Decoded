/**
 * @author ssrbazpur
 * @Time Complexity:O(N+M)
 * @Space Complexity:O(max(N,M))
 */

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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2)
    {

        ListNode *p1 = l1;
        ListNode *p2 = l2;
        int carry = 0;

        ListNode *dummyNode = new ListNode(-1);
        ListNode *it = dummyNode;

        while (p1 != NULL && p2 != NULL)
        {

            int sum = p1->val + p2->val + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            sum = sum % 10;

            ListNode *newNode = new ListNode(sum);

            it->next = newNode;
            it = newNode;
            p1 = p1->next;
            p2 = p2->next;
        }

        while (p1 != NULL)
        {
            int sum = p1->val + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            sum = sum % 10;
            p1->val = sum;
            it->next = p1;
            it = p1;

            p1 = p1->next;
        }

        while (p2 != NULL)
        {
            int sum = p2->val + carry;
            if (sum >= 10)
                carry = 1;
            else
                carry = 0;
            sum = sum % 10;

            p2->val = sum;
            it->next = p2;
            it = p2;

            p2 = p2->next;
        }
        if (carry == 1)
        {
            it->next = new ListNode(1);
        }

        return dummyNode->next;
    }
};