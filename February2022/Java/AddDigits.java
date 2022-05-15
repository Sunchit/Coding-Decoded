
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


// @saorav21995
// Easy


class Solution {
    public int addDigits(int num) {
        int res = 0;
        while (true) {
            int d = num%10;
            res += d;
            num /= 10;
            if (num == 0) {
                if (res/10 == 0)
                    break;
                num = res;
                res = 0;
            }
        }
        return res;
    }
}

