class Solution {

	// TC : O(n)
	// SC : O(n)
	public String removeStars(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '*'){
				stack.push(s.charAt(i));
				continue;
			} else {
				stack.pop();
			}
		}
		if(stack.isEmpty()) return "";
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}