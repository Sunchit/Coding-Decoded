class Solution {
	// TC : O(n)
	// SC : O(1)

	public int longestSubsequence(String s, int k) {
		int sum = 0;
		int numOfOnes = 0;
		int numOfZeros = 0;
		//Take all zeros
		for(char c: s.toCharArray()){
			if (c == '0') {
				numOfZeros++;
			}
		}
		// Take as many ones as possible from right to left.
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if(c == '1') {
				sum += Math.pow(2, s.length() - 1 - i);
				if (sum <= k) {
					numOfOnes++;
				} else{
					break;
				}
			}
		}
		return numOfOnes + numOfZeros;
	}
}