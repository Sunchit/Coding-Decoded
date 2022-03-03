
// @saorav21994
// TC : O(n)
// SC : O(1)

// iterate through the array, keep incrementing count whenever diff is same. If diff mismatch, calculate answer [ n*(n+1)/2 ] if count >= 3 and reset count variable to 2. Continue the process untill array end reached. After loop once again perform the same operation for calculating answer of the remaining count variable value.


class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int l = nums.length;
        if (l < 3)
            return 0;
        int count = 1;
        int answer = 0;
        int diff = nums[1] - nums[0];
        for (int i = 1; i < l; i++) {
            if ((nums[i] - nums[i-1]) == diff)
                count += 1;
            else {
                if (count >= 3)
                    answer += ((count-2) * (count-1)) / 2;
                //System.out.println(answer + " - " + count + " - " + nums[i]);
                count = 2;
                diff = nums[i] - nums[i-1];
            }
        }
        if (count >= 3) {
            answer += ((count-2) * (count-1)) / 2;
        }
        return answer;
    }
}

// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer,HashSet<Integer>> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!hm.containsKey(nums[i])){
                HashSet<Integer> hs=new HashSet<>();
                hs.add(i);
                hm.put(nums[i],hs);
            }else{
                hm.get(nums[i]).add(i);
            }
        }
        int c=0;
        for(int i=2;i<nums.length;i++){
            int d=nums[i]-nums[i-1];
            int k=2;
            while(i-k>=0&&hm.containsKey(nums[i]-(k*d))&&hm.get(nums[i]-(k*d)).contains(i-k)){
                c++;
                k++;
            }
        }
        
        return c;
    }
}
// @coding decoded
class Solution {

    // TC : O(n)
    // SC : O(n)
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int total = 0;
        for(int i=2;i<A.length;i++){
            // Third- Second == Second-First
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                dp[i] = dp[i-1]+1;
            } else{
                dp[i] = 0;
            }
            total += dp[i];
        }
        return total;
    }

    // TC: O(n)
    // SC: O(1)
    public int numberOfArithmeticSlices(int[] A) {
        int previousCount = 0;
        int total = 0;
        for(int i=2;i<A.length;i++){
            if(A[i] - A[i-1] == A[i-1] - A[i-2]){
                previousCount = previousCount +1;
            } else{
                previousCount = 0;
            }
            total += previousCount;
        }
        return total;
    }
}