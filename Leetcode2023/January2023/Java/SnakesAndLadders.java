class Solution {
 public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean visited[][] = new boolean[n][n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[n-1][0]=true;
        int minSteps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int currVal = queue.poll();

                if(currVal == n*n) return minSteps;

                for(int diceValue=1;diceValue<=6;diceValue++) {

                    if(diceValue + currVal > n*n) continue;
                    int pos[] = findCoordinates(diceValue + currVal,n);
                    int row = pos[0];
                    int col = pos[1];
                    if(visited[row][col]==true) continue;

                    visited[row][col]=true;

                    if(board[row][col] == -1) queue.add(diceValue + currVal);
                    else queue.add(board[row][col]);
                }
            }
            minSteps++;
        }
        return -1;
    }
    
    private int[] findCoordinates(int currVal,int n){
        
        int r = n - (currVal-1)/n - 1;
        int c = (currVal-1) % n;

        if(r%2==n%2) return new int[]{r,n-1-c};
        
        else return new int[]{r,c};
    }
}
