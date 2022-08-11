// https://leetcode.com/problems/snakes-and-ladders/
// @author: @anuj0503
class Solution {
    public int snakesAndLadders(int[][] board) {
        int n= board.length;
        
        int[] path = new int[n*n + 1];
        boolean[] visited = new boolean[n*n + 1];
        
        int index = 1;
        boolean flag = true;
        for(int i = n - 1; i >= 0; i--){
            if(flag){
                for(int j = 0; j < n; j++){
                    if(board[i][j] != -1){
                        path[index] = board[i][j];
                    }
                    index++;
                }
                flag = false;
            } else {
                for(int j = n - 1; j >= 0; j--){
                    if(board[i][j] != -1){
                        path[index] = board[i][j];
                    }
                    index++;
                }
                flag = true;
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        
        while(!queue.isEmpty()){
            int[] head = queue.poll();
            index = head[0];
            int count = head[1];
            
            if(index == n*n){
                return count;
            }
            
            if(visited[index]) continue;
            
            visited[index] = true;
            
            for(int i = 1; i <= 6; i++){
                int newIndex = Math.min(index + i, n*n);
                
                if(path[newIndex] != 0){
                    queue.offer(new int[]{path[newIndex], count + 1});
                } else {
                    queue.offer(new int[]{newIndex, count + 1});
                }
            }
        }
        
        return -1;
    }
}
