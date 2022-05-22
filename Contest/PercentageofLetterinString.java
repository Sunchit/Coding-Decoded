class Solution {
	//TC : O(n)
	// SC : O(1)
	// 100* (count of letter in input string/length of string )
	public int percentageLetter(String s, char letter) {
		int count = 0;
		for(char c: s.toCharArray()) {
			if(c == letter) {
				count++;
			}
		}
		return (100*count)/s.length();
	}
}