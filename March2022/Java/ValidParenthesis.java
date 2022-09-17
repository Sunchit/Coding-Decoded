

// @saorav21994
// TC : O(n)
// SC : O(n)

class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (st.isEmpty() == true) {
                if (ch == '{' || ch == '[' || ch == '(') {
                    st.push(ch);
                }
                else {
                    return false;
                }
            }
            else {
                if (ch == '(' || ch == '[' || ch == '{') {
                    st.push(ch);
                }
                else if (ch == '}') {
                    if (st.peek() == '{')
                    {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (ch == ']') {
                    if (st.peek() == '[')
                    {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
                else if (ch == ')') {
                    if (st.peek() == '(')
                    {
                        st.pop();
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        if (st.isEmpty() == true) return true;
        return false;
    }
}

// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public boolean isValid(String s) {
        LinkedList<Character> li=new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                li.addFirst(s.charAt(i));
            }else if(s.charAt(i)==')'&&li.size()>0&&li.getFirst()=='('){
                li.removeFirst();
            }else if(s.charAt(i)==']'&&li.size()>0&&li.getFirst()=='['){
                li.removeFirst();
            }else if(s.charAt(i)=='}'&&li.size()>0&&li.getFirst()=='{'){
                li.removeFirst();
            }else{
                return false;
            }
            
        }
        
        return (li.size()==0);
    }
}

// Author : @romitdutta10
// TC: O(N)
// SC: O(N)
// Problem : https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c == ')') {
                if(stack.size() == 0 || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            } else if(c == '}') {
                if(stack.size() == 0 || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            } else if(c == ']') {
                if(stack.size() == 0 || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        
       return stack.isEmpty();
    }
}

// Author : @romitdutta10
// TC: O(N)
// SC: O(N)
// Problem : https://leetcode.com/problems/valid-parentheses/
// Another shorter solution but with similar time and space complexity

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
	for (char c : s.toCharArray()) {
		if (c == '(')
			stack.push(')');
		else if (c == '{')
			stack.push('}');
		else if (c == '[')
			stack.push(']');
		else if (stack.isEmpty() || stack.pop() != c)
			return false;
	}
	return stack.isEmpty();
    }
}
