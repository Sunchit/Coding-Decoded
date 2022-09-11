
// @saorav21994
// TC : O(nlogn)
// SC : O(n)

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        
        // Arrange in 2-D array to facilitate easy sorting
        int [][] cand = new int[n][2];
        for (int i = 0 ; i < n; i++) {
            cand[i][0] = speed[i];
            cand[i][1] = efficiency[i];
        }
        
        Arrays.sort(cand, (a,b) -> (b[1] - a[1]));    // Descending order based on cand.efficiency
        
        PriorityQueue<Integer> dump = new PriorityQueue<>();
        
        long totsp = 0L, res = 0L;
        
        for (int [] emp : cand) {
            
            int spd = emp[0];
            dump.offer(spd);
            
            if (dump.size() <= k) 
                totsp += spd;
            else 
                totsp += spd - dump.poll();
            
            res = Math.max(res, totsp*(long)emp[1]);        // notice the term atmost -> meaning we need not necessarily consider all the k candidates
        }
        
        return (int)(res%1000000007);
        
    }
}
