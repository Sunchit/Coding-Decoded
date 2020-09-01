class Solution {

    // 0 1 2 3
    //  max val (i +j + k) +l = 6
    // l = 6 -i - j - k
    public String largestTimeFromDigits(int[] A) {
        int maxTime = -1;
        int maxHours = -1;
        int maxMin = -1;

        for(int i=0;i<A.length;i++){
            for(int j=0;j<A.length;j++){
                for(int k=0;k<A.length;k++){
                    if(i==j || j==k || k==i){
                        continue;
                    }

                    int hoursTens = A[i];
                    int hoursUnits = A[j];

                    int minsTens = A[k];
                    int minsUnit = A[6-i-j-k];


                    int hour = hoursTens*10 + hoursUnits;

                    int min = minsTens * 10+ minsUnit;

                    int totalTime  = hour*60 + min;
                    if(hour<24 && min< 60 && (totalTime)> maxTime){
                        maxTime = totalTime;
                        maxHours = hour;
                        maxMin = min;
                    }
                }
            }
        }

        if(maxHours == -1 || maxMin == -1){
            return "";
        } else {
            // 9:45 => 09:45 , 8:08
            return padding(maxHours) + ":" + padding(maxMin);
        }

    }
    private String padding(int no){
        String str = ""+no;
        if(str.length()==1){
            str = "0" + str;
        }
        return str;
    }

}