class Solution {
	// TC : O(n)
	// SC : O(n)
	public int calPoints(String[] ops) {
		Integer topEl = null;
		Integer secondtopEl= null;
		Stack<Integer> st = new Stack<Integer>();
		for(String op : ops){
			switch(op.toCharArray()[0]){
				case 'C' : st.pop();
					break;
				case 'D' :  topEl = st.peek();
					st.push(2*topEl);
					break;
				case '+' :  topEl = st.pop();
					secondtopEl = st.peek();
					st.push(topEl);
					st.push(topEl+secondtopEl);
					break;
				default: st.push(Integer.parseInt(op));
					break;

			}
		}

		int ans = 0;
		while(!st.isEmpty()){
			ans  = ans + st.pop();
		}
		return ans;
	}
}