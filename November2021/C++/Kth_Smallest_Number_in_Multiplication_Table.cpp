//authoor:shyam2025
// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/
class Solution {
public:
    int findKthNumber(int m, int n, int k) {
        int low=1, high =m*n;
        
        while(low<high)
        {
            int mid=low+(high-low)/2;
            int cap=count(m,n,mid);
            if(cap>=k)
                high=mid;
            else
                low=mid+1;
        }
        return low;
    }
    
    int count(int m,int n,int x)
    {
        int res=0;
        for(int i=1;i<=m;i++)
        {
            res+=min(x/i,n);
        }
        return res;
    }
};