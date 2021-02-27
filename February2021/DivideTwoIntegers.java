class Solution {

    public int divide(int dividend, int divisor) {
        long count =0;
        boolean neg = false;

        if((dividend<0 && divisor>0) || (dividend>0 && divisor<0)){
            neg = true;
        }
        long lDividend = Math.abs((long)dividend);
        long   lDivisor = Math.abs((long)divisor);


        if(lDivisor == 0 || (lDividend< lDivisor)){
            return 0;
        }

        count = longDivide(lDividend, lDivisor);

        if(count> Integer.MAX_VALUE){
            if(neg){
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }

        } else {
            if(neg){
                return (int)(-count);
            } else{
                return (int)count;
            }
        }

    }

    private long longDivide(long lDividend, long ldivisor){
        if(lDividend< ldivisor){
            return 0;
        }
        long count =1; // quotient
        long sum = ldivisor; // comparable dividend

        while((2*sum) <= lDividend){
            sum = 2*sum;
            count = 2*count;
        }
        return count + longDivide(lDividend- sum, ldivisor);
    }
}