
// @saorav21994
// TC : O(nlogn)
// SC : O(n)

// Similar as ladder-bricks problem to go to maximum number of buildings -> FarthestBuildingYouCanReach in leetcode

class Solution {
    public int scheduleCourse(int[][] courses) {
                
        Arrays.sort(courses, (a, b) -> (a[1]-b[1]));    // Ascending sort on the endTime (2nd) column
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        int curTime = 0;
        
        for (int [] course : courses) {
            
            int duration = course[0];
            int end = course[1];
            
            curTime += duration;
            
            if (curTime > end)  {
                
                // Search if the max element taken before is more than this -> then consider this element and remove the previous max element
                if (!maxHeap.isEmpty() && maxHeap.peek() > duration) {
                    curTime -= maxHeap.poll();
                    maxHeap.offer(duration);
                }
                else {
                    curTime -= duration;
                }
                
            }
            else  {
                maxHeap.offer(duration);
            }
            
        }
        
        return maxHeap.size();
        
        
    }
}
