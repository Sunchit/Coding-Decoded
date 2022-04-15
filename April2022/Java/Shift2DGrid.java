
// Author: Shobhit Behl (LC: shobhitbruh)
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        
        LinkedList<Integer> li=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                li.addLast(grid[i][j]);
            }
        }
        while(k-->0){
        int f=li.removeLast();
        li.addFirst(f);
        }
        List<List<Integer>> al=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> g=new ArrayList<>();
            for(int j=0;j<m;j++){
               g.add(li.removeFirst()); 
            }
            al.add(g);
        }
        
        return al;
    }
}

// @saorav21994
// TC : O(n^2)  
// SC : O(n^2) 

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ele = m * n;
        k = k % ele;
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int idx = findShiftedIndex(i, j, n, k, ele);
                sublist.add(grid[idx/n][idx%n]);
            }
            res.add(sublist);
        }
        
        return res;
    }
    
    public int findShiftedIndex(int i, int j, int col, int k, int ele) {
        return (i * col + j - k + ele) % ele;
    }
}
