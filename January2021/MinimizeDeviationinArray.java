class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int el: nums){
            if(el%2==1){
                set.add(el*2);
            } else{
                set.add(el);
            }
        }

        int diff = Integer.MAX_VALUE;
        while(true){
            int maxVal = set.last();
            int minVal = set.first();
            int curDiff = maxVal -minVal;
            diff = Math.min(diff, curDiff);
            if(maxVal%2 ==0){
                set.remove(maxVal);
                set.add(maxVal/2);
            } else{
                // terminal state;
                return diff;
            }
        }
    }
}