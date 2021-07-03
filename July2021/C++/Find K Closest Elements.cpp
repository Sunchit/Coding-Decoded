//explanaiton
//https://leetcode.com/explore/challenge/card/july-leetcoding-challenge-2021/608/week-1-july-1st-july-7th/3800/discuss/106426/JavaC++Python-Binary-Search-O(log(N-K)-+-K)

class Solution {
public:
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low=0, high=arr.size()-k;
        while(low<high)
        {
            int mid=low+(high-low)/2;
            // cout<<mid<<endl;
            if(x-arr[mid]>arr[mid+k]-x)
                low=mid+1;
            else
                high=mid;
        }
        // cout<<low<<" "<<high<<endl;
        return vector<int>(arr.begin()+low,arr.begin()+low+k);
    }
};