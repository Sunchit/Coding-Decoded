class Solution {

    // TC: O(n)
    // SC: O(n) 1,2,3,4
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int el: nums){
            int currfreq = map.getOrDefault(el, 0);
            map.put(el, currfreq+1);
        }

        int maxLHS = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int currKey = entry.getKey();
            int freq =entry.getValue();
            int currLHS = 0;
            if(map.containsKey(currKey+1)){ // 1 1 1 1
                currLHS = freq + map.get(currKey+1);
            }
            maxLHS = Math.max(maxLHS, currLHS);
        }
        return maxLHS;

    }
}