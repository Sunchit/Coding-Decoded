//author : shyam2520
//https://leetcode.com/problems/unique-binary-search-trees/

class Solution {
public:
    int numTrees(int n) {
        vector<int> dict(n+1,0);
        dict[0]=1;
        dict[1]=1;
        // dict[2]=2;
        return findnode(n,dict);
    }
    
    int findnode(int n,vector<int>& dict)
    {
        if(dict[n])
            return dict[n];
        int ans=0;
        for(int i=1;i<=n;i++)
        {
            ans+=findnode(i-1,dict)*findnode(n-i,dict);
            
        }
        dict[n]=ans;
        return ans;
    }
};