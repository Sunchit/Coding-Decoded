class Solution {

	// TC : O(1)
	// SC : O(1)
	public int convertTime(String current, String correct) {
		int minsCurrent = getMinutes(current);
		int minsCorrect = getMinutes(correct);

		int diff = minsCorrect - minsCurrent;
		int count = 0;
		if(diff>0) {
			int[] denominations = new int[] { 60, 15, 5, 1};

			for(int denomination : denominations){
				if(diff % denomination ==0){

					count += diff/denomination;
					break;
				} else {

					count += diff/denomination;
					diff = diff% denomination;
				}

			}
		}
		return count;

	}

	private int getMinutes(String timeStamp){
		String[] time = timeStamp.split(":");

		int hours = Integer.parseInt(time[0]);
		int mins = Integer.parseInt(time[1]);
		return hours* 60 + mins;
	}
}