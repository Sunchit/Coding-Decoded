// https://leetcode.com/problems/remove-stones-to-minimize-the-total/
class Solution {
public:
    // TC: O(nlogn) + O(klogn)
    // SC: O(n)
    int minStoneSum(vector<int>& piles, int k) {
        priority_queue<int> pq; // max heap
        int sum = 0;
        
        for (int &it : piles) {
            pq.push(it);
            sum += it;
        }
        
        while (k > 0 && !pq.empty()) {
            int largestElement = pq.top();
            pq.pop();
            int remove = largestElement / 2;
            sum -= remove;
            pq.push(largestElement - remove);
            k--;
        }
        
        return sum;
    }
};
