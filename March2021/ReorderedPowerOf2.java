class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] inputDigitFreq = freqCount(N);
        for(int i=0;i<31;i++){
            int powerOf2 = (int)Math.pow(2, i);
            int[] powerOf2FreqCount = freqCount(powerOf2);
            if(compareArray(inputDigitFreq, powerOf2FreqCount)){
                return true;
            }

        }
        return false;
    }

    private boolean compareArray(int[] freqCount1,int[] freqCount2){

        for(int i=0;i<10;i++){
            if(freqCount1[i]!= freqCount2[i]){
                return false;
            }
        }
        return true;
    }

    private int[] freqCount(int n){
        int[] digitFreq = new int[10];
        while(n>0){
            digitFreq[n%10]++;
            n = n/10;
        }
        return digitFreq;
    }
}