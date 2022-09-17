class Solution {
    // TC : O(n)
    // SC : O(1)
    public int minimumOperations(int[] nums) {
        // make count for even & odd indices elements
        int[] freqOdd = new int[100001];
        int[] freqEven = new int[100001];

        int n = nums.length;
        int oddMax = 0;
        int oddMaxFreq = 0;
        int oddSecondMax = 0;
        int oddSecondMaxFreq = 0;


        for (int i = 1; i < n; i += 2) {
            freqOdd[nums[i]]++;
        }

        for (int i = 0;i<freqOdd.length;i++) {
            if(freqOdd[i] > oddMaxFreq){
                oddMaxFreq = freqOdd[i];
                oddMax = i;
            }
        }


        for (int i = 0;i<freqOdd.length;i++) {
            if(freqOdd[i]> oddSecondMaxFreq && i!=oddMax){
                oddSecondMaxFreq = freqOdd[i];
                oddSecondMax = i;
            }
        }

        int evenMax = 0;
        int evenMaxFreq = 0;
        int evenSecondMax = 0;
        int evenSecondMaxFreq = 0;

        for (int i = 0; i < n; i += 2) {
            freqEven[nums[i]]++;
        }


        for (int i = 0;i<freqEven.length;i++) {
            if(freqEven[i] > evenMaxFreq){
                evenMaxFreq = freqEven[i];
                evenMax = i;
            }
        }


        for (int i = 0;i<freqEven.length;i++) {
            if(freqEven[i]> evenSecondMaxFreq && i!=evenMax){
                evenSecondMaxFreq = freqEven[i];
                evenSecondMax = i;
            }
        }

        // if max candidate for odd & even is different, can use them.
        if (oddMax != evenMax) {
            return n - oddMaxFreq - evenMaxFreq;
        }
        // else take either of second max for odd or even.
        return Math.min(n - oddMaxFreq - evenSecondMaxFreq, n - oddSecondMaxFreq - evenMaxFreq);
    }
}