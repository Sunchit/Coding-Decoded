class Solution {
  public int kIncreasing(int[] arr, int k) {
    int ans = 0;
    for(int i=0; i < k; i++){
      List<Integer> list = new ArrayList<>();
      for(int j=i; j < arr.length; j = j+k)
        list.add(arr[j]);
      ans += list.size() - lengthOfLIS(list);
    }
    return ans;
  }

  private int lengthOfLIS(List<Integer> nums){
    List<Integer> incrList = new ArrayList<>();
    incrList.add(nums.get(0));

    for(int i=1; i < nums.size(); i++){
      int lastItem = incrList.get(incrList.size()-1);
      if(nums.get(i) >= lastItem){
        incrList.add(nums.get(i));
      } else {
        int idx = nextGreaterItem(incrList, nums.get(i));
        incrList.set(idx, nums.get(i));
      }
    }
    return incrList.size();
  }

  // Perform Binary Search to get the next greater element
  private int nextGreaterItem(List<Integer> list, int num){
    int left = 0, right = list.size()-1;
    while(left < right) {
      int mid = left + (right - left) / 2;
      if(num >= list.get(mid))
        left = mid + 1;
      else
        right = mid;
    }
    return left;
  }
}