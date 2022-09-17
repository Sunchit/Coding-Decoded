class Solution {
  public int[] beautifulArray(int N) {
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(1);
    while (ans.size() < N) {
      ArrayList<Integer> tmp = new ArrayList<>();
      for (int el : ans)   {
        if(2*el -1<=N)
          tmp.add(el * 2 - 1);
      }
      for (int el : ans) {
        if(2*el <=N)
          tmp.add(el * 2);
      }
      ans = tmp;
    }
    int[] res = new int[N];
    for(int i=0;i<N;i++){
      res[i] = ans.get(i);
    }
    return res;
  }
}
