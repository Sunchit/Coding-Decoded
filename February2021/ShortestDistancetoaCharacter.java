class Solution {

    // TC : O(n)
    // SC: O(n)
    public int[] shortestToChar(String s, char c) {
        int len = s.length();

        int[] leftDis = new int[len];
        int[] rightDis =new int[len];

        Arrays.fill(leftDis, Integer.MAX_VALUE);
        Arrays.fill(rightDis, Integer.MAX_VALUE);

        int runningDis = Integer.MAX_VALUE;

        //left to right direction
        for(int i=0;i<len;i++){
            if(s.charAt(i) == c){
                runningDis = 0;
                rightDis[i] = runningDis;
            } else{

                if(runningDis != Integer.MAX_VALUE) {
                    runningDis++;
                    rightDis[i] = runningDis;
                }
            }
        }
        runningDis = Integer.MAX_VALUE;

        // right to left direction

        for(int i=len-1;i>=0;i--){
            if(s.charAt(i) == c){
                runningDis = 0;
                leftDis[i] = runningDis;
            } else{

                if(runningDis != Integer.MAX_VALUE) {
                    runningDis++;
                    leftDis[i] = runningDis;
                }
            }
        }

        int[] ans = new int[len];

        for(int i=0;i<len;i++){
            ans[i] = Math.min(rightDis[i], leftDis[i]);
        }
        return ans;
    }
}