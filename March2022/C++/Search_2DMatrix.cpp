class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int mid,idx,m=matrix.size(),n=matrix[0].size(),l=0,r=m-1;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(matrix[mid][0]<=target && matrix[mid][n-1]>=target)
            {
                idx=mid;
                break;
            }
            if(matrix[mid][n-1]<target) l=mid+1;
            else r=mid;
        }
        if(l>=r) idx=l;
        if(matrix[idx][0]<=target && matrix[idx][n-1]>=target)  return search(matrix[idx],target,n);
            
        return false;
    }
    bool search(vector<int>& temp,int& target,int& n)
    {
        int mid,l=0,r=n-1;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(temp[mid]==target) return true;
            if(temp[mid]>target) r=mid;
            else l=mid+1;
        }
        return temp[l]==target;
    }
};