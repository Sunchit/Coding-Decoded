https://www.youtube.com/watch?v=DA9yg_6VYT8
class Solution {
	public void reverseString(char[] s) {
		int start = 0;
		int end = s.length-1;

		while(start<end){
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}
		return;

	}
}

// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
	public void reverseString(char[] s) {
		int l = s.length;
		for (int i = 0; i < l/2; i++) {
			char ch = s[i];
			s[i] = s[l-i-1];
			s[l-i-1] = ch;
		}

	}
}