class Solution {
    // TC: O(n*m*log(n*m))
    // SC: O(m*n)
    int[] dir = new int[]{ 0, 1, 0,-1, 0};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] efforts = new int[m][n];
        for(int[] effort: efforts){
            Arrays.fill(effort, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0]-b[0]));
        efforts[0][0] = 0;
        
        pq.offer(new int[]{0,0,0});
        
        while(!pq.isEmpty()){
            int[] head = pq.poll();
            int x = head[1];
            int y =head[2];
            int currentEffort = head[0];
            if(x == m-1 && y == n-1){
                return currentEffort;
            }
            for(int k=0;k<4;k++){
                int newX = x + dir[k];
                int newY = y + dir[k+1];
                //k= 0 x, y+1
                //k=1 x+1, y 
                // k=2 x, y-1
                // k-3 x-1, y
                if(newX>=0 && newX<m && newY>=0 &&newY<n){
                    int nextEffort = Math.max(currentEffort, Math.abs(heights[newX][newY] - heights[x][y]));
                    
                    if(nextEffort< efforts[newX][newY]){
                        efforts[newX][newY] =nextEffort;
                        pq.offer(new int[]{nextEffort, newX, newY});
                    }
                }
            }
        }
        return 0;
            
    }
}