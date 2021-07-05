class Solution {

  // TC : O(r*c)
  // SC  : O(r*c)
  public int[][] matrixReshape(int[][] mat, int r, int c) {

    if (mat.length * mat[0].length != r * c)  {
      return mat;
    }
    // the equalit is met
    int[][] newMatrix = new int[r][c];

    int sR = 0;
    int sC = 0;

    for(int i=0;i<mat.length;i++){
      for(int j=0;j<mat[0].length;j++){
        if(sC == c){
          sR++;
          sC = 0;
        }
        newMatrix[sR][sC] = mat[i][j];
        sC++;
      }
    }

    return newMatrix;
  }
}