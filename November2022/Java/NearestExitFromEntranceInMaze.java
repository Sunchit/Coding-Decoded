// @saorav21994

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        
        int [] abs = {0, -1, 0, 1};
        int [] ord = {-1, 0, 1, 0};

        // BFS
        Queue<Coor> queue = new LinkedList<>();
        queue.offer(new Coor(entrance[0], entrance[1], 0));

        while (!queue.isEmpty()) {

            Coor point = queue.poll();
            int x = point.x;
            int y = point.y;
            int cd = point.dist;

            if (x == 0 || y == 0 || x == maze.length-1 || y == maze[0].length-1) {
                if (x != entrance[0] || y != entrance[1]) {
                    // System.out.println(x + " - " + y);
                    return cd;
                }
            }

            for (int i = 0; i < 4; i++) {   // all four directions

                int row = x + abs[i];
                int col = y + ord[i];

                if (valid(row, col, maze)) {
                    queue.offer(new Coor(row, col, cd+1));
                    maze[row][col] = '+';
                }

            }

        }

        return -1;

    }


    public boolean valid(int x, int y, char [][] maze) {
        return (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == '.');
    }

    class Coor {
        int x;
        int y;
        int dist;

        public Coor(int _x, int _y, int _dist) {
            this.x = _x;
            this.y = _y;
            this.dist = _dist;
        }
    }

}
