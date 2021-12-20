class Solution {
public:
    vector<vector<int>> minimumAbsDifference(vector<int>& arr) {
        sort(begin(arr),end(arr));
        vector<vector<int>> res;
        
        int absdiff=INT_MAX;
        for(int i=1;i<arr.size();i++)
       {
            // absdiff=min(absdiff,arr[i]-arr[i-1]);
            if((arr[i]-arr[i-1])==absdiff)
                res.push_back({arr[i-1],arr[i]});
            else if((arr[i]-arr[i-1])<absdiff)
            {
                res={{arr[i-1],arr[i]}};
                absdiff=arr[i]-arr[i-1];
            }
        }
        // for(int i=1;i<arr.size();i++)
        // {
        //     if((arr[i]-arr[i-1])==absdiff)
        //         res.push_back({arr[i-1],arr[i]});
        // }
        return res;
    }
};