// @saorav21994

class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        // using 2 pointers, calculate the sum of all same colored balloons in current group and subtract the maximum among them, and add the remaining sum to the total time as answer.
        
        int i = 1, j = 0;
        int currentSum = neededTime[0];
        int max = neededTime[0];
        
        for (i = 1; i < neededTime.length; i++) {
            
            if (colors.charAt(i) == colors.charAt(j)) {
                max = Math.max(max, neededTime[i]);
                currentSum += neededTime[i];
            }
            
            else {
                currentSum -= max;
                max = neededTime[i];
                currentSum += max;
                j = i;
            }
                
                
        }
        
        currentSum -= max;
        
        return currentSum;
        
    }
}
