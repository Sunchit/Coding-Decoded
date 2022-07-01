class Solution {

    // TC : O(nlogn)
    // SC : O(1)
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort on the basis of unit in the box in decreasing order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int maxUnitOfboxes = 0;
        for (int[] box : boxTypes) {
            int noOfBoxes = box[0];
            int noOfUnits= box[1];

            if (truckSize >= noOfBoxes) {
                maxUnitOfboxes += noOfBoxes * noOfUnits;
                truckSize -= noOfBoxes;
            }else {
                maxUnitOfboxes += truckSize * noOfUnits;
                return maxUnitOfboxes;
            }
        }
        return maxUnitOfboxes;
    }
}