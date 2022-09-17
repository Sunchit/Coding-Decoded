
// @saorav21994
// TC : O(log(1000)) ~ O(1)
// SC : O(1)


// one liner

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        /*
         Total number of rounds = minutesToTest/minutesToDie (= N) + 1 = N+1
         (+1) because , if pig does not die in N, then (N+1)th contains poison.
         So (N+1)^p (where p = # of pigs) >= buckets.
         So, taking log both side,
         p >= log(bucktes)/log(N+1) ,
         => p = Math.ceil(Math.log(buckets) / Math.log(N+1))
        */
        
        return (int) Math.ceil(Math.log(buckets) / Math.log((minutesToTest/minutesToDie) + 1));
    }
}


// Descriptive

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        if (buckets-- == 1) {
            return 0;
        }
        int base = minutesToTest/minutesToDie + 1;
        int res = 0;
        while (buckets > 0) {
            buckets = buckets/base;
            res += 1;
        }
        return res;
    }
}
