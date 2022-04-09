
// @saorav21994
// TC : O(n)
// SC : O(n)



class Solution {
    
    private class Pair {
        int index;
        char bracket;
        
        public Pair(int index, char bracket) {
            this.index = index;
            this.bracket = bracket;
        }
        
    }
    
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder(s);
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                st.push(new Pair(i, sb.charAt(i)));
            }
            else if (sb.charAt(i) == ')') {
                if (st.isEmpty()) 
                    st.push(new Pair(i, sb.charAt(i)));
                else {
                    Pair top = st.peek();
                    if (top.bracket == '(')
                        st.pop();
                    else {
                        st.push(new Pair(i, sb.charAt(i)));
                    }
                }
            }
        }
        
        while (!st.isEmpty()) {
            Pair top = st.pop();
            sb = sb.deleteCharAt(top.index);
        }
        
        return sb.toString();
    }
}

// Author : @romitdutta10
// TC : O(n)
// SC : O(n)
// Solution with Stack

class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Temp> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c== ')') {
                if(c == '(') {
                    stack.push(new Temp(c, i));
                } else {
                    if(stack.isEmpty()) {
                        stack.push(new Temp(c, i));
                    } else {
                        if(stack.peek().ch == '(') {
                            stack.pop();
                        } else {
                            stack.push(new Temp(c, i));
                        }
                    }
                }
            } 
            
            //System.out.println(stack);
        }
        
        Set<Integer> unwantedIndices = new HashSet<>();
        
        while(!stack.isEmpty()) {
            unwantedIndices.add(stack.pop().index);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            if(!unwantedIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    class Temp {
        char ch;
        int index;
        
        Temp(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
        
        public String toString() {
            return "ch = " + ch + " index = " + index;
        }
    }
}

// Author : @romitdutta10
// TC : O(n)
// SC : O(n)
// Solution without using Stack

class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        
        char ch[] = s.toCharArray();
        
        for(int i=0;i<ch.length;i++) {
            
            if(ch[i] == '(') {
                count++;
            } else if(ch[i]==')') {
                if(count > 0) {
                    count--;
                } else {
                    ch[i] = 0;
                }
            } 
        }
        
        count = 0;
        
        
        for(int i=ch.length-1;i>=0;i--) {
            
            if(ch[i] == ')') {
                count++;
            } else if(ch[i]=='(') {
                if(count > 0) {
                    count--;
                } else {
                    ch[i] = 0;
                }
            } 
        }
        
        StringBuilder result = new StringBuilder();
        
        for(char c : ch) {
            if(c!=0)
                result.append(c);
        }
        
        return result.toString();
        
        
    }
}



