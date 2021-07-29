class Solution {

  // TC : O(n*m)
  public int[][] updateMatrix(int[][] matrix) {
    Queue<int[]> queue=new LinkedList<>();
    for(int i=0;i<matrix.length;i++){
      for(int j=0;j<matrix[0].length;j++){
        if(matrix[i][j]==0)
          queue.add(new int[]{i,j});
        else
          matrix[i][j]=-1;
      }
    }
    int[][] dirs= {{0,1},{-1,0},{1,0},{0,-1}};

    int length=0;
    while(!queue.isEmpty()){
      int size=queue.size();
      length++;
      while(size-->0){
        int[] cell=queue.poll();
        for(int[] dir:dirs){
          int r=cell[0]+dir[0];
          int c=cell[1]+dir[1];
          if(r<0 || c<0 || r==matrix.length || c==matrix[0].length || matrix[r][c]!=-1)                                   continue;
          matrix[r][c]=length;
          queue.add(new int[]{r,c});
        }
      }
    }
    return matrix;
  }
}