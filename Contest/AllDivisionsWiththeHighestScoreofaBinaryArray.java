class Solution {
    // TC : O(n)
    // SC : O(n)
    public List<Integer> maxScoreIndices(int[] nums) {
        int noOfOnes =0;
        for (int el: nums) {
            if(el == 1){
                noOfOnes++;
            }
        }


        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        int rightScore = noOfOnes;//1
        int leftScore = 0;
         int maxScore = rightScore + leftScore;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                leftScore++;
            } else if (nums[i] == 1) {
                rightScore--;
            }
            int currentScore  = rightScore + leftScore;
            if (currentScore > maxScore) {
                ans = new ArrayList<>();
                maxScore = currentScore;
                ans.add(i+1);
            } else if (currentScore == maxScore) {
                ans.add(i+1);
            }
        }

        return ans;
    }
}