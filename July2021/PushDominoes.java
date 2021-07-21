class Solution {
  public String pushDominoes(String dominoes) {
    int n = dominoes.length();
    int[] left = new int[n];
    int nearestLeftIndex = -1;
    for(int i=n-1;i>=0;i--){
      char c = dominoes.charAt(i);
      if(c == 'L'){
        nearestLeftIndex = i;
      }
      else if(c == 'R'){
        nearestLeftIndex = -1;
      }
      left[i] = nearestLeftIndex;
    }

    int[] right = new int[n];
    int nearestRigtIndex = -1;
    for(int i=0;i<n;i++){
      char c = dominoes.charAt(i);
      if(c == 'L'){
        nearestRigtIndex = -1;
      }
      else if(c == 'R'){
        nearestRigtIndex = i;
      }
      right[i] = nearestRigtIndex;
    }
    char[] ans = new char[n];
    for(int i=0;i<n;i++){


      if(dominoes.charAt(i) == '.'){
        int nearestLeft = left[i];
        int nearestRight = right[i];

        int leftDiff = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft  - i);
        int rightDiff = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight  - i);

        if(leftDiff == rightDiff){
          ans[i] = '.';
        } else if(leftDiff < rightDiff){
          ans[i] = 'L';
        } else if(leftDiff > rightDiff){
          ans[i] = 'R';
        }
      } else {
        ans[i] = dominoes.charAt(i) ;
      }

    }
    return new String(ans);
  }
}
