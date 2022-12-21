// @saorav21994

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        boolean [] visited = new boolean[1001];

        int l = rooms.size();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            visited[room] = true;
            for (Integer key : rooms.get(room)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }

        for (int i = 0; i < l; i++) {
            if (!visited[i])
                return false;
        }

        return true;

    }
}
