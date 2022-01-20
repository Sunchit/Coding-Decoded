
class Solution {
	public int minEatingSpeed(int[] piles, int H) {

		long low = 1;
		long high = piles[0];
		for(int pile: piles){
			high = Math.max(high, pile);
		}
		while(low<high){
			long mid = low + (high-low)/2;
			if(!isPossibleToEatAll(piles, H, mid)){
				low = mid + 1;
			} else{
				high =mid;
			}
		}
		return (int)low;
	}

	private boolean isPossibleToEatAll(int[] piles, int hours,long currK){
		long count =0;
		for(long pile: piles){
			count += pile/currK;
			if(pile%currK!=0){
				count++;
			}
		}
		return (count<=hours);
	}
}

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
