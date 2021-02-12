class Solution {
    public int numberOfSteps (int num) {
        int count = 0;
        while(num!=0){
            if(num%2 ==0 ){
                num= num/2;
            } else{
                num = num-1;
            }
            count++;
        }
        return count;
    }

    public int numberOfSteps (int num) {
        if(num ==0 ){
            return 0;
        }
        return 1 + (num%2 ==0 ? numberOfSteps(num/2) : numberOfSteps(num-1));
    }
}