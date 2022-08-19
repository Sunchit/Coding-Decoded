// https://leetcode.com/problems/knight-dialer/
// @author: @anuj0503
class Solution {
    int mod;
    int[][] moves;
    long[][][] dp;
    public int knightDialer(int k) {
        long count = 0;
        mod = 1000000007;
        moves = new int[][]{{2, 1}, {-2, 1}, {-2, -1}, {2, -1}, {1, 2}, {-1, 2}, {1, -2}, {-1, -2}};
        dp = new long[4][3][k+1];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                count = (count%mod + getCount(i, j, 1, k)%mod)%mod;
            }
        }

        count = (count%mod + getCount(3, 1, 1, k)%mod)%mod;
        
        return (int)count;
    }

    private long getCount(int x, int y, int z, int k){
        if(x < 0 || x >= 4 || y < 0 || y >= 3) return 0;
        
        if(x == 3 && y != 1) return 0;
        
        if(z == k) return 1;
        
        if(dp[x][y][z] != 0) return dp[x][y][z];
        
        long cnt = 0;
        for(int[] move : moves){
            int newX = x + move[0];
            int newY = y + move[1];
            
            cnt = (cnt%mod + getCount(newX, newY, z+1, k)%mod)%mod;
        }
        
        dp[x][y][z] = cnt;
        return cnt;
    }
}
