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
    int posidx;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        posidx=postorder.size()-1;
        int l=0,r=inorder.size()-1;
        return createTree(inorder,postorder,l,r);
    }

    TreeNode* createTree(vector<int>& inorder,vector<int>& postorder,int l,int r)
    {
        if(l>r || posidx<0) return NULL;
        if(l==r)
        {
            return new TreeNode(postorder[posidx--]);
        }

        int inidx=binsearch(inorder,postorder,l,r);
        TreeNode* currnode=new TreeNode(postorder[posidx--]);
        currnode->right = createTree(inorder,postorder,inidx+1,r);
        currnode->left = createTree(inorder,postorder,l,inidx-1);
        return currnode;
    }

    int binsearch(vector<int>& inorder,vector<int>& postorder,int l,int r)
    {

        while(l<r)
        {
            int mid = l+(r-l)/2;
            if(inorder[mid]==postorder[posidx]) return mid;
            if(inorder[mid]>postorder[posidx]) r=mid;
            else l=mid+1;
        }
        return l;
    }

};