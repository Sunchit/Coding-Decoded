class Solution {

    // TC: O(n)
    // SC : O(n)
    public int longestConsecutive(int[] nums) {
        Set<Integer> set  =  new HashSet<>();
        for(int el: nums){
            set.add(el);
        }
        int maxLen = 0;
        for(int el: nums){
            int currLen = 1;
            int left = el;
            int right =el;
            while(set.contains(left-1)){
                currLen++;
                set.remove(left-1);
                left--;
            }

            while(set.contains(right+1)){
                currLen++;
                set.remove(right+1);
                right++;
            }

            maxLen= Math.max(maxLen, currLen);

        }
        return maxLen;
    }
}