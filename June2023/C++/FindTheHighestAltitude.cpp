class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int maxAltitude = 0;
        int currAltitude = 0;
        
        for (int it : gain) {
            currAltitude += it;
            maxAltitude = max(maxAltitude, currAltitude);
        }
        
        return maxAltitude;        
    }
};
