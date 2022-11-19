// @saorav21994

// DFS - O(n^2)
// Better solution exists with union-find O(n) 

class Solution {
    public int removeStones(int[][] stones) {
         
        Set<int[]> set = new HashSet<>();
        int count = 0;
        for (int [] stone: stones) {
            if (!set.contains(stone)) {
                count += 1;
                dfs(stones, set, stone);
            }
        }
        return stones.length-count;
    }

    public void dfs(int [][] stones, Set<int[]> set, int [] stone) {
        set.add(stone);
        for (int [] cur: stones) {
            if (!set.contains(cur)) {
                if (cur[0] == stone[0] || cur[1] == stone[1]) {
                    dfs(stones, set, cur);
                }
            }
        }
    }
}
