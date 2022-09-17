class Solution {
public:
    // TC: O(vlogv) + O(hlogh) => v = no. of vertical cuts, h -> no. of horizontal cuts
    // SC: O(1)
    int maxArea(int h, int w, vector<int>& horizontalCuts, vector<int>& verticalCuts) {
        sort(horizontalCuts.begin(), horizontalCuts.end());
        sort(verticalCuts.begin(), verticalCuts.end());
        
        int hLength = horizontalCuts.size();
        int vLength = verticalCuts.size();
        
        int maxHeight = max(horizontalCuts[0] - 0, h - horizontalCuts[hLength - 1]);
        for (int i = 1; i < hLength; i++) {
            int currHeight = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHeight = max(maxHeight, currHeight);
        }
        
        int maxWidth = max(verticalCuts[0] - 0, w - verticalCuts[vLength - 1]);
        for (int i = 1; i < vLength; i++) {
            int currWidth = verticalCuts[i] - verticalCuts[i - 1];
            maxWidth = max(maxWidth, currWidth);
        }
        
        return (long) maxHeight * maxWidth % 1000000007;
    }
};
