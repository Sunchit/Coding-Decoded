#define SIZE 31
class Trie{
    public:
    vector<Trie*>  child;
    bool isend;
    Trie()
    {
        this->child.resize(2,NULL);
        this->isend=false;
    }
    
};
class Solution {
public:
    
    void insert(Trie* root,int n)
    {
        Trie* curroot=root;
        for(int i=SIZE;i>=0;i--)
        {
            int currbit=n>>i & 1;
            if(!curroot->child[currbit])
            {
                curroot->child[currbit]=new Trie();
            }
            curroot=curroot->child[currbit];
            
        }
        curroot->isend=true;
    }
    int query(Trie* root,int num)
    {
        int xorval=0;
        Trie* curroot=root;
        for(int i=SIZE;i>=0;i--)
        {
            int currbit=num>>i & 1;
            if(curroot->child[!currbit])
            {
                xorval=xorval | 1<<i;
                curroot=curroot->child[!currbit];
            }
            else if(curroot->child[currbit])
            {
                curroot=curroot->child[currbit];
            }
            else break;
        }
        return xorval;
    }
    int findMaximumXOR(vector<int>& nums) {
        if(nums.size()==1)  return 0;
        
        Trie* root= new Trie();
        // insert(root,nums[0]);
        
        int res=0;
        for(int i=0;i<nums.size();i++)
        {
            res=max(res,query(root,nums[i]));
            insert(root,nums[i]);
        }
        
        return res;
        
    }
};