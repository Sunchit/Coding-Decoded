class Solution {
public:
   
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        vector<int> ans;
        int left=0;
        int right=arr.size()-1;
        while(right-left>=k)
        {
            if(x-(arr[left])>(arr[right]-x))
            {
                //cout<<left<<endl;
                left++;
            } 
            else
            {
                //cout<<right<<endl;
                right--;
            }
            
        }
        for(int i=left; i<=right; i++)
        {
            ans.push_back(arr[i]);
        }
        return ans;
    }
};