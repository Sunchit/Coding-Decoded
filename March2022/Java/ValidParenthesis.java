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