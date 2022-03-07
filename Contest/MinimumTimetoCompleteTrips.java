class Solution {
	// TC : O(nlogn)
	// SC: O(1)
	public long minimumTime(int[] time, int totalTrips) {


		long left = 1;
		long min = time[0];
		for(int t : time){
			min = Math.min(min, t);
		}
		long right = totalTrips * min;

		while(left < right){
			long mid = (right - left) / 2 + left;

			//How many trip we can do
			long total = totalTripInGivenTime(time, mid);
			//We cannot reach totalTrips, means mid is too small
			if(total < totalTrips){
				left = mid + 1;
			}else{
				//We can reach totalTrips, but we want right to be as small as possible
				//Therefore, we don't need to + 1
				right = mid;
			}
		}

		return left;
	}

	private long totalTripInGivenTime(int[] time, long givenTime){
		long totalTrips = 0l;
		for(int tripTime : time){
			totalTrips += ((long)givenTime) / tripTime;
		}
		return totalTrips;
	}
}