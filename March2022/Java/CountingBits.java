//Author : Shobhit Behl (LC : shobhitbruh)
class Solution {
    public int[] countBits(int n) {
        int[] arr=new int[n+1];
        for(int i=0;i<arr.length;i++){
            int j=i;
            int c=0;
            while(j>0){
                c++;
                j^=(j&(~j+1));
            }
            
            arr[i]=c;
        }
        return arr;
    }
}

// @Coding Decoded
class Solution {

    // TC : O(n) // SC: O(n)
    public int[] countBits(int num) {
        // 0 ..n
        int[] ans = new int[num + 1];
        ans[0] = 0;

        for(int i = 1; i <= num; i++){
            // even in nature
            if((i %2) == 0){
                ans[i] = ans[i/2];
            }else{
                // i is odd
                ans[i] = ans[i - 1] + 1;
            }
        }

        return ans;
    }
}
