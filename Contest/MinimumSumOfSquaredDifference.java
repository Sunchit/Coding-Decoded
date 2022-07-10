// https://leetcode.com/problems/minimum-sum-of-squared-difference/
// @author: anuj0503
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int[] freq = new int[100001];
        long sum = 0;
        long result = 0;
        int maxAbsDiff = -1;
        
        // Finding the frequency of the absolute diff of the numbers at each index.
        for(int i = 0; i < nums1.length; i++){
            int absDiff = Math.abs(nums1[i] - nums2[i]);
            
            freq[absDiff]++;
            sum += absDiff;
            
            maxAbsDiff = Math.max(maxAbsDiff, absDiff);
        }
        
        
        long k = k1 + k2;
        
        // If sum of diff is less than allowed operation then we can reduce diff to zero somehow.
        if(sum <= k)
            return 0;
        
        // We will use greedy approach to reduce the diff by reducing highest numbers first
        // since reducing higher number will contribute less in square sum.
        for(int i = maxAbsDiff; i >= 1 && k > 0; i--){
            if(freq[i] <= k){
                k -= freq[i];
                freq[i - 1] += freq[i];
                freq[i] = 0;
            } else {
                freq[i-1] += k;
                freq[i] -= k;
                k = 0;
                break;
            }
        }
        
        // calculating the sum
        for(int i = 0; i <= 100000; i++){
            result += ((long)i * (long)i * (long)freq[i]);
        }
        
        return result;
    }
}
