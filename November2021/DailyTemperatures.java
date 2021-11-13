class Solution {
	public int[] dailyTemperatures(int[] temperatures) {
		int len = temperatures.length;
		int[] ans = new int[len];

		Stack<Integer> st = new Stack<>();

		for(int i=0;i<len;i++){

			while(!st.empty() && temperatures[st.peek()] <temperatures[i]){
				//System.out.println(temperatures[st.peek()]);
				// found an increasing value for st.peek() index
				ans[st.peek()] = i - st.peek();
				st.pop();
				// System.out.println( "removed "+ st.peek() + " " + temperatures[st.pop()]);

			}

			st.push(i);

		}
		return ans;
	}
}



