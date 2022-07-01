class Solution {
public:
    // TC: O(nlogn)
    // SC: O(1)
    int maximumUnits(vector<vector<int>>& boxTypes, int truckSize) {
        // Sort on the basis of unit in the box in decreasing order
        sort(boxTypes.begin(), boxTypes.end(), [](auto &a, auto &b) { return b[1] < a[1]; } );
        
        int maxUnitOfBoxes = 0;
        
        for (auto &box : boxTypes) {
            int noOfBoxes = box[0];
            int noOfUnits = box[1];
            
            if (truckSize >= noOfBoxes) {
                maxUnitOfBoxes += (noOfBoxes * noOfUnits);
                truckSize -= noOfBoxes;
            } else {
                maxUnitOfBoxes += (truckSize * noOfUnits);
                return maxUnitOfBoxes;
            }
        }
        
        return maxUnitOfBoxes;
    }
};
