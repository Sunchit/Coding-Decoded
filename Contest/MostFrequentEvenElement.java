class Solution {

	// TC : O(n)

	public int mostFrequentEven(int[] nums) {
		int[] freq = new int[100001];
		for(int el: nums){
			freq[el]++;
		}
		int maxFreq = 0;
		int ans = -1;
		for(int i=0;i<freq.length;i++){

			if(i%2==0 && freq[i]> maxFreq){
				maxFreq = freq[i];
				ans = i;
			}
		}
		return ans;
	}
}