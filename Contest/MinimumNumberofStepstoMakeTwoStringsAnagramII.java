class Solution {
	// TC : O(len(s+t))
	// SC : O(1)
	public int minSteps(String s, String t) {
		int[] freqS =freqMap(s);
		int[] freqT =freqMap(t);
		int ans = 0;
		for(int i=0;i<26;i++){
			int maxChar = Math.max(freqS[i] , freqT[i]);
			ans += (maxChar - freqS[i] ) + (maxChar - freqT[i]);
		}
		return ans;
	}

	private int[] freqMap(String s){
		int[] freq = new int[26];
		for(char c: s.toCharArray()){
			freq[c-'a']++;
		}
		return freq;
	}
}
