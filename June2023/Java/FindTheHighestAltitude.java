class Solution {
    public int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currAltitude = 0;
        
        for (int it : gain) {
            currAltitude += it;
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }
        
        return maxAltitude;
    }
}
