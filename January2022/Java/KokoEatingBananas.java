
// Koko-Eating-Bananas
// TC : O(nlogn)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = piles.length;
        Arrays.sort(piles);
        if (l == h)
            return piles[l-1];
        int low = 1;
        int high = piles[l-1];
      
        // apply binary search
        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = count(piles, mid);
            if (cnt <= h)
                high = mid-1;
            else 
                low = mid+1;
        }
        return low;
    }
    
    private int count(int [] piles, int max) {
        int res = 0;
        for (int pile : piles) {
            res += (Math.ceil((double)pile/max));
        }
        return res;
    }
}
