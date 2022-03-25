
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

// Sort the array in descending order based on difference between tarvel cost of city a and city b for ith person. Then add cost to result untill half for any one is reached, after which take the higher value as we can max make half candidates visit a particular city. 

class Solution {
    public int twoCitySchedCost(int[][] costs) {
 
        Arrays.sort(costs, (a,b) -> (Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1])));
        
        int a = 0, b = 0, l = costs.length;
        int resCost = 0;
        
        for (int i = 0; i < l; i++) {
            if (costs[i][0] <= costs[i][1]) {
                if (a < (l/2)) {
                    a += 1;
                    resCost += costs[i][0];
                }
                else {
                    b += 1;
                    resCost += costs[i][1];
                }
            }
            else {
                if (b < (l/2)) {
                    b += 1;
                    resCost += costs[i][1];
                }
                else {
                    a += 1;
                    resCost += costs[i][0];
                }
            }
        }
        
        return resCost;
        
    }
}
