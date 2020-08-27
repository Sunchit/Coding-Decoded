class FirstRightInterval {
    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        // base case
        if(len==0){
            return new int[0];
        }
        if(len==1){
            return new int[]{-1};
        }

        int[] ans = new int[len];
        //<StartPoint, Index>
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>();
        for(int i=0;i<len;i++){
            // the keys will sorted as per the start pointer
            sortedMap.put(intervals[i][0], i);
        }

        for(int i=0;i<len;i++){

            // First Key greater than the end point of i interval
            Integer minimumFirstKey = sortedMap.ceilingKey(intervals[i][1]);
            // Ceiling key gives the first key greater than equal to the key passed
            if(minimumFirstKey==null){
                ans[i] =-1;
            } else{
                ans[i] = sortedMap.get(minimumFirstKey);
            }
        }
        return ans;

    }
}