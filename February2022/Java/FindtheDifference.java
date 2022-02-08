class Solution {
	public char findTheDifference(String s, String t) {
		char ans ='0';
		for(char c : s.toCharArray()){
			ans ^= c;
		}
		for(char c : t.toCharArray()){
			ans ^= c;
		}

		ans ^= '0';
		return ans;
	}
}