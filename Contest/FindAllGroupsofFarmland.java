// https://leetcode.com/problems/find-all-groups-of-farmland/
// @author: anuj0503
class Solution {
    int[][] dir = new int[][]{{1, 0}, {0, 1}};

    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> r = new ArrayList<>();

        int m = land.length;
        int n = land[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if(!visited[i][j] && land[i][j] == 1){
                    r.add(bfs(i, j, land, visited));
                }
            }
        }

        if(r.isEmpty()) return new int[0][0];

        int[][] result = new int[r.size()][4];
        for(int i = 0 ; i < r.size(); i++){
            result[i] = r.get(i);
        }

        return result;
    }

    private int[] bfs(int x, int y, int[][] land, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        int endX = x, endY = y;
        while(!queue.isEmpty()){
            int size = queue.size();

            while(size-->0){
                int[] head = queue.poll();
                
                if(visited[head[0]][head[1]]) continue;
                
                visited[head[0]][head[1]] = true;
                if(endX < head[0]) endX = head[0];
                if(endY < head[1]) endY = head[1];

                for(int[] d : dir){
                    int newX = d[0] + head[0];
                    int newY = d[1] + head[1];
                    
                    if(newX >= 0 && newX < land.length && newY >= 0 && newY < land[0].length && land[newX][newY] == 1){
                        queue.add(new int[]{newX, newY});
                    }
                }

             }
        }
        return new int[]{x, y, endX, endY};
    }
}
