class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    vector<int> findClosestElements(vector<int>& arr, int k, int x) {
        int low = 0;
        int high = arr.size() - 1;
        
        while (high - low >= k) {
            if (abs(arr[low] - x) > abs(arr[high] - x)) {
                low++;
            } else {
                high--;
            }
        }
        
        vector<int> ans;
        while (low <= high) {
            ans.push_back(arr[low]);
            low++;
        }
        
        return ans;
    }
};
