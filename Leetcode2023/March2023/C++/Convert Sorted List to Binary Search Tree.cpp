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
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head) return NULL;
        ListNode* node=head;
        while(node->next) node=node->next;

        return getTreeNode(head);
    }

    TreeNode* getTreeNode(ListNode* l)
    {
        if(l==NULL) return NULL;
        if(!l->next) return new TreeNode(l->val);

        ListNode* currNode=getMiddleNode(l);
        ListNode* temp =currNode->next;
        currNode->next=NULL;
        TreeNode* curr=new TreeNode(currNode->val);
        curr->left=getTreeNode(l);
        curr->right=getTreeNode(temp);
        return curr;
    }

    ListNode* getMiddleNode(ListNode* l)
    {
        ListNode* slow= l;
        ListNode* fast = l,*prev= NULL;
        while(fast && fast->next)
        {
            prev=slow;
            slow= slow->next;
            fast=fast ? fast->next?fast->next->next:fast->next:fast;
        }
        prev->next = NULL;
        return slow;

    }

};