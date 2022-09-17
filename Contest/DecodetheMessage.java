class Solution {
	public String decodeMessage(String key, String message) {
		char[] map = new char[26];
		int i = 0;
		for (char c : key.toCharArray()) {
			if (i < 26 && c != ' ' && map[c - 'a'] == 0) {
				map[c - 'a'] = (char) (i + 'a');
				i++;
			}
		}
		String ans = "";
		for (char c : message.toCharArray()) {
			ans += (c == ' ' ? ' ' : map[c - 'a']);
		}
		return  ans;
	}
}