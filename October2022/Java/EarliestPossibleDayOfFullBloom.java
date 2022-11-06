
// @saorav21994

class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        
        // basically sort by growTime in descending order.
        
        int l = plantTime.length;
        
        int [][] zip = new int[l][2];       // [0] = plantTime, [1] = growTime
        for (int i = 0; i < l; i++) {
            zip[i][0] = plantTime[i];
            zip[i][1] = growTime[i];
        }
        
        Arrays.sort(zip, (a,b) -> (b[1]-a[1]));
        
//         for (int [] z : zip) {
//             System.out.println(z[0] + " -> " + z[1]);
//         }
        
        int res = 0, baseTime = 0;
        
        for (int i = 0; i < l; i++) {
            
            int newTime = baseTime + zip[i][0] + zip[i][1];
            res = Math.max(res, newTime);
            baseTime += zip[i][0];
            
        }
        
        return res;
        
        
    }
}
