class Solution {

	// TC : O(n)
	// SC : O(n)
	public String removeKdigits(String num, int k) {
		Stack<Character> st = new Stack<>();
		int i=0;
		for(;i<num.length() && k>0;){
			while(k>0 && !st.isEmpty() && num.charAt(i)< st.peek()){
				st.pop();

				k--;
			}

			st.push(num.charAt(i));
			i++;
		}



		while(!st.isEmpty() && k>0){
			st.pop();
			k--;

		}


		String ans = "";
		while(!st.isEmpty()){
			ans = st.pop() + ans;
		}

		ans = ans + num.substring(i, num.length());
		// 0002000
		i = 0;
		while(i<ans.length()){
			if(ans.charAt(i) == '0'){
				i++;
			}    else {
				break;
			}
		}
		// "000000"
		return ans.substring(i).length() == 0 ? "0" : ans.substring(i);
	}
}
