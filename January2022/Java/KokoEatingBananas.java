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