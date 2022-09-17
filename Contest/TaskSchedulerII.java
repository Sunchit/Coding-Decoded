// https://leetcode.com/problems/task-scheduler-ii/
// @author: anuj0503
class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        int n = tasks.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        long[] lastTime = new long[n];
        long currTime = 0;
        
        for(int i = 0; i < n; i++){
            if(map.get(tasks[i]) == null){
                map.put(tasks[i], i);
                currTime++;
                lastTime[i] = currTime;
            } else {
                currTime++;
                long timeGap = currTime - lastTime[map.get(tasks[i])] - 1;
                long diff = Math.max(0L, space - timeGap);
                currTime += diff;
                
                lastTime[i] = currTime;
                map.put(tasks[i], i);
            }
        }
        
        return lastTime[n - 1];
    }
}
