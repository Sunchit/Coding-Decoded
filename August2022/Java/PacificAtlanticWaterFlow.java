// https://leetcode.com/problems/pacific-atlantic-water-flow/
// @author: anuj0503
class Solution {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        int m = heights.length;
        int n = heights[0].length;


        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                boolean[][] visited = new boolean[m][n];
                visited[i][j] = true;
                if(dfs(i, j, visited, heights) == 3){
                    result.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }

        return result;
    }

    private int dfs(int x, int y, boolean[][] visited, int[][] heights){
        int path = 0;
        for(int[] d : dir){
            int newX = d[0] + x;
            int newY = d[1] + y;

            if(newX < 0 || newY < 0) path = (path | 1);
            else if(newX >= heights.length || newY >= heights[0].length) path = (path | 2);
            else if(heights[newX][newY] <= heights[x][y] && !visited[newX][newY]){
                visited[newX][newY] = true;
                path = (path | dfs(newX, newY, visited, heights));
            }
        }

        return path;
    }
}


//===============================================================================================================================================================



// @saorav21994
// TC : O(m*n)
// SC : O(m*n)

class Solution {
    
    int [] abs = {0, 0, 1, -1};
    int [] ord = {1, -1, 0, 0};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int m = heights.length;
        int n = heights[0].length;
        
        boolean [][] visitPacific = new boolean[m][n];
        boolean [][] visitAtlantic = new boolean[m][n];
        
        Queue<Pair> queue = new LinkedList<>();
        
        // first traverse for Pacific Ocean
        
        // first row and first column respectively to be added to queue as they are directly reachable
        for (int i = 0; i < n; i++)
            queue.offer(new Pair(0, i));
        for (int i = 0; i < m; i++) 
            queue.offer(new Pair(i, 0));
        
        bfs(queue, heights, visitPacific);
        
        // second traverse for Atlantic Ocean
        
        // last row and last column respectively to be added to queue as they are directly reachable
        for (int i = 0; i < n; i++)
            queue.offer(new Pair(m-1, i));
        for (int i = 0; i < m; i++) 
            queue.offer(new Pair(i, n-1));
        
        bfs(queue, heights, visitAtlantic);
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitPacific[i][j] && visitAtlantic[i][j]) {
                    List<Integer> sublist = new ArrayList<>();
                    sublist.add(i);
                    sublist.add(j);
                    res.add(new ArrayList<>(sublist));
                }
            }
        }
        
        return res;       
        
    }
    
    
    public void bfs(Queue<Pair> queue, int [][] heights, boolean [][] visited) {
        
        while (!queue.isEmpty()) {
            
            Pair cur = queue.poll();
            
            visited[cur.x][cur.y] = true;
            
            for (int i = 0; i < 4; i++) {
                int x = cur.x+abs[i];
                int y = cur.y+ord[i];
                
                if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !visited[x][y] && heights[x][y] >= heights[cur.x][cur.y]) {
                    queue.offer(new Pair(x, y));
                }
            }
            
        }
        
    }
    
    
    class Pair {
        
        int x;
        int y;
        
        public Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}
