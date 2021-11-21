//author :shyam2520
//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
    int preidx;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        
        preidx=postorder.size()-1;
        return createTree(inorder,postorder,0,inorder.size()-1);
        
    }
    
    int findval(vector<int>& inroder,vector<int>& preorder,int preidx,int start,int end)
    {
        if(start>=end)
            return -1;
        for(int i=start;i<=end;i++)
        {
            if(inroder[i]==preorder[preidx])
                return i;
        }
        return -1;
    }
    
    TreeNode* createTree(vector<int>& inorder,vector<int>& postorder,int start,int end)
    {
        if(start>end)
            return NULL;
        if(start==end)
        {   
            preidx--;
            return new TreeNode(inorder[start]);
        }
        int inidx=findval(inorder,postorder,preidx,start,end);
        if(inidx==-1)
            return NULL;
        TreeNode* newnode=new TreeNode(inorder[inidx]);
        --preidx;
        newnode->right=createTree(inorder,postorder,inidx+1,end);
        newnode->left=createTree(inorder,postorder,start,inidx-1);
        
        return newnode;
        
        
    }
};


// Solution II

class Solution {
    int idx;
    int solve1(vector<int> &inorder,int a,int start,int end)
    {
       for(int i=start;i<=end;i++)
           if(inorder[i]==a)
               return i;
        return -1;
    }
    TreeNode* solve(vector<int> &inorder, vector<int> &postorder, int start, int end)
    {
        if(start>end)
            return NULL;
     int val=postorder[idx];
     TreeNode *curr=new TreeNode(val);
     idx--;


        if(start==end)
            return curr;

     int pos=solve1(inorder,val,start,end);
     curr->right=solve(inorder,postorder,pos+1,end);
     curr->left=solve(inorder,postorder,start,pos-1);

     return curr;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        idx=inorder.size()-1;
        return(solve(inorder,postorder,0,inorder.size()-1));
    }
};