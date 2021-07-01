class Solution {

  // TC : O(n2)
  public List<Integer> grayCode(int n) {
    List<Integer> list = new ArrayList<>();
    list.add(0);

    if(n == 0) return list;
    list.add(1);

    int curr = 1;
    for(int i = 2;i<=n;i++){
      curr *= 2;
      for(int j =  list.size()-1;j>=0;j--){
        list.add(curr+list.get(j));
      }
    }
    return list;
  }
}