// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    fun calPoints(ops: Array<String>): Int {
       var st=ArrayDeque<Int>()
        for(i in ops.indices){
            if(ops[i].equals("+")){
                var a:Int=st.pop();
                var b:Int=st.pop();
                st.push(b);
                st.push(a);
                st.push(a+b);
            }else if(ops[i].equals("C")){
                st.pop();
            }else if(ops[i].equals("D")){
                var d:Int=st.pop();
                st.push(d);
                st.push(2*d);
            }else{
                st.push(ops[i].toInt());
            }
        }
        
        var sum:Int=0;
        while(!st.isEmpty()){
            var j:Int=st.pop();
            sum+=j;
        }
        
        return sum; 
    }
}