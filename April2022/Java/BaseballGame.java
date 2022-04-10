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
}