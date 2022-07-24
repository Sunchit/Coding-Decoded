class Solution {
public:
    bool searchMatrix(vector<vector<int>>& a, int target) {
        
        int n = a.size();
        int m = a[0].size();
        for(int i=0;i<n;i++)
        {
            if (binary_search(a[i].begin(),a[i].end(),target))
                return 1;
        }
        return 0;
    }
};
