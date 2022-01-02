class Solution {
	// public int numPairsDivisibleBy60(int[] time) {
	//     int ans = 0;
	//     Arrays.sort(time);
	//     for(int i=0;i<time.length;i++){
	//         for(int j=i+1;j<time.length;j++){
	//             if((time[i] + time[j])%60 ==0){
	//                 ans++;
	//             }
	//         }
	//     }
	//     return ans;
	// }

	/// TC : O(n) + 60
	// SC : O(1)
	public int numPairsDivisibleBy60(int[] time) {
		int[] remainderMap = new int[60];
		for(int songTime : time){
			int remainder = songTime%60;
			remainderMap[remainder]++;
		}

		int ans = 0;
		//20,40
		// 40, 20
		for(int i = 1; i < 30; i++){
			ans += (remainderMap[i] * remainderMap[60 - i]);
		}

		// kC2 -> k*(k-1)/2
		if(remainderMap[0] > 0){
			ans += remainderMap[0] * (remainderMap[0] - 1) / 2;
		}

		// pC2 -> p*(p-1)/2
		if(remainderMap[30] > 0){
			ans += remainderMap[30] * (remainderMap[30] - 1) / 2;
		}


		return ans;

	}
}