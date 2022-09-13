// https://leetcode.com/problems/maximum-performance-of-a-team/
class Solution {
private:
    static bool comp(pair<int, int>& a, pair<int, int>& b) {
        return a.second > b.second;
    }
        
public:
    // TC: O(nlogn) + O(n)
    // SC: O(2 * n) + O(k)  -> 2d array + priority queue
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        vector<pair<int, int>> engineers;
        
        for (int i = 0; i < n; i++) {
            engineers.push_back({speed[i], efficiency[i]});
        }
        
        // sort in decreasing order of efficiency
        sort(engineers.begin(), engineers.end(), comp);
        
        // Min Heap
        priority_queue<int, vector<int>, greater<int>> pq;
        
        long sum = 0;
        long ans = 0;
        
        for (auto engineer : engineers) {
            int currSpeed = engineer.first;
            int currEfficiency = engineer.second;       
            sum += currSpeed;
            pq.push(currSpeed);
            if (pq.size() > k) {
                sum -= pq.top();
                pq.pop();
            }
            ans = max(ans, sum * currEfficiency);
        }
        
        return ans % 1000000007;
    }
};
