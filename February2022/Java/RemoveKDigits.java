


// @saorav21994
// Stack implementation 
// TC : O(n)
// SC : O(n)


class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        
        for (char ch : num.toCharArray()) {
            while (!st.isEmpty() && st.peek() > ch && k > 0) {
                st.pop();
                k -= 1;
            }   
            st.push(ch);
        }
        
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k -= 1;
        }
        
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb = sb.reverse();
        
        // remove leading zeros
        int i = 0;
        for (char ch : sb.toString().toCharArray()) {
            if (ch != '0')
                break;
            i += 1;
        }
        
        String res = sb.toString().substring(i, sb.length());
        if (res == "" ||  res == null)
            return "0";
        return res;
        
        
    }
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
