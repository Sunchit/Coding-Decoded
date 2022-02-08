// Author Shobhit Behl( LC : shobhitbruh)
class Solution {
    public int addDigits(int num) {
        char[] n=Integer.toString(num).toCharArray();
        int sum=num;
        while(n.length>1){
            sum=0;
            for(char x:n){
                sum+=x-'0';
            }
            n=Integer.toString(sum).toCharArray();
        }
        
        return sum;
    }
}