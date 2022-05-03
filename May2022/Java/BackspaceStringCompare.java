class Solution {

	// TC : O(n)
	// SC : O(n)
	public boolean backspaceCompare(String s, String t) {
		return updateStr(s).equals(updateStr(t));
	}

	private String updateStr(String str) {
		StringBuilder ans = new StringBuilder();

		for (char c : str.toCharArray()) {

			if (c != '#') {
				ans.append(c);
			} else if (ans.length() > 0) {
				ans.deleteCharAt(ans.length() - 1);// O(1)
			}
		}
		return ans.toString();
	}
}