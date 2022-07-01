
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        Arrays.sort(boxTypes, (a,b) -> (b[1] - a[1]));
        
        int i = 0, sum = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            sum += (Math.min(truckSize, boxTypes[i][0]) * boxTypes[i][1]);
            truckSize -= boxTypes[i][0];
            i += 1;
        }
        return sum;
        
    }
}
