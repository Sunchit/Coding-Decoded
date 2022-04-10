

// TC : O(n)
// SC : O(n)

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (String s : ops) {
            if (s.equals("+")) {
                int top = stack.pop();
                int newValue = top + stack.peek();
                stack.push(top);
                stack.push(newValue);
                res += newValue;
            }
            else if (s.equals("D")) {
                int newValue = stack.peek() * 2;
                stack.push(newValue);
                res += newValue;a
            }
            else if (s.equals("C")) {
                int newValue = stack.pop();
                res -= newValue;
            }
            else {
                int newValue = Integer.parseInt(s);
                stack.push(newValue);
                res += newValue;
            }
        }
        return res;
    }
}
=======
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<ops.length;i++){
            if(ops[i].equals("+")){
                int a=st.pop();
                int b=st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }else if(ops[i].equals("C")){
                st.pop();
            }else if(ops[i].equals("D")){
                int d=st.pop();
                st.push(d);
                st.push(2*d);
            }else{
                st.push(Integer.parseInt(ops[i]));
            }
        }
        
        int sum=0;
        while(st.size()>0){
            int j=st.pop();
            sum+=j;
        }
        
        return sum;
    }

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