class Solution {

    // TC : O(n)
    // SC : O(n)
    public int maximumGap(int[] nums) {

        int maxGap =0;
        int n  = nums.length;
        // Base Case :
        if(n  < 2)
            return 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i : nums){
            min = Math.min(min,i);
            max = Math.max(max,i);
        }


        int bucketSize =  (int)Math.ceil((double)(max-min)/(n -1));

        int[] minOfBucket = new int[n -1];
        int[] maxOfBucket = new int[n -1];

        Arrays.fill(minOfBucket, Integer.MAX_VALUE);
        Arrays.fill(maxOfBucket, Integer.MIN_VALUE);

        //Set the min and max of bucket.
        for(int i =0;i<n ; i++){
            if(nums[i]== min || nums[i]==max)
                continue;

            int bucketIndexForCurrentEl = (nums[i] - min)/bucketSize;


            minOfBucket[bucketIndexForCurrentEl] = Math.min(minOfBucket[bucketIndexForCurrentEl], nums[i]);
            maxOfBucket[bucketIndexForCurrentEl] = Math.max(maxOfBucket[bucketIndexForCurrentEl], nums[i]);
        }


        // Calculate gap using MinB- MaxA

        for(int i =0;i<n -1;i++){
            if(maxOfBucket[i]==Integer.MIN_VALUE) // empty buckets
                continue;
            maxGap = Math.max(minOfBucket[i] - min, maxGap);
            min = maxOfBucket[i];
        }

        maxGap = Math.max(maxGap, max-min);// 2
        return maxGap;
    }
}