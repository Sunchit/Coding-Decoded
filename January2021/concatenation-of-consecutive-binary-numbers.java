class Solution {
    public int concatenatedBinary(int n) {
        int mod = 1000000007 ;
        int newNo =0;

        for(int num=1;num<=n;num++){

            String binaryRep= Integer.toBinaryString(num);

            for(char ch : binaryRep.toCharArray()){
                int val= (ch=='0')?0:1;

                newNo= ((newNo*2)%mod + val) % mod;
            }
        }

        return newNo;
    }
}