// @saorav21994

class Solution {
    public int findCircleNum(int[][] isConnected) {
        
        // k-connected component == number of islands
        
        int r = isConnected.length;
        int c = r;  // square matrix
        
        Queue<Integer> queue = new LinkedList<>();
        int [] hash = new int[r];
        
        int province = 0;
        
        for (int i = 0; i < r; i++) {
            
            if (hash[i] == 0) {
                
                province += 1;
                
                queue.offer(i);
                
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    if (hash[index] != 1) {
                        for (int j = 0; j < r; j++) {
                            if (isConnected[index][j] == 1 && index != j) {
                                queue.offer(j);
                            }
                        }
                    }
                    hash[index] = 1;
                }
                
            }
        }
        
        return province;
        
    }
}
