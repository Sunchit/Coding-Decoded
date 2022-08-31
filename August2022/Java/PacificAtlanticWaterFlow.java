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
