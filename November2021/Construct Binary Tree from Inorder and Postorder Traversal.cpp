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