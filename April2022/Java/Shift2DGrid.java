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