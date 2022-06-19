class Solution {
	// TC : O(n)
	// SC : O(1)
	public String greatestLetter(String s) {
		int[] lowerCase = new int[26];
		int[] upperCase = new int[26];

		for(char c: s.toCharArray()){
			if(Character.isLowerCase(c)){
				lowerCase[c-'a']++;
			} else {
				upperCase[c-'A']++;
			}
		}

		for(int i=25;i>=0;i--){
			if(lowerCase[i] >0 && upperCase[i]>0) {
				return  new String( "" +(char)(i +'A'));
			}
		}
		return "";
	}
}