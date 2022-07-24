class Solution {
    private:
    void mergeSort(vector<pair<int,int>> &v, vector<int> &count,
                  int left, int mid, int right)
    {
        vector<pair<int,int>> temp(right-left+1);
        int i = left, j = mid+1, k = 0;
        
        while(i<=mid and j<=right)
        {
            if(v[i].first<=v[j].first) temp[k++] = v[j++];
            else
            {
                count[v[i].second] += right-j+1;
                temp[k++] = v[i++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = v[i++];
        }
        while (j <= right) {
            temp[k++] = v[j++];
        }
        for (int i = left; i <= right; i++)
            v[i] = temp[i-left];
        
    }
    void merge(vector<pair<int,int>> &v, 
               vector<int> &count, int left, int right)
    {
        if(left>=right) return;
        int mid = (left+right)>>1;
        merge(v,count,left,mid);
        merge(v,count,mid+1,right);
        
        mergeSort(v,count,left,mid,right);
    }
public:
    vector<int> countSmaller(vector<int>& nums) {
        
        int n = nums.size();
        vector<pair<int,int>> v;
        
        for(int i=0;i<n;i++) v.push_back({nums[i],i});
        
        vector<int> count(n,0);
        merge(v,count,0,n-1);
        return count;
    }
};
