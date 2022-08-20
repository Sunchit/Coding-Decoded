// https://leetcode.com/problems/hand-of-straights/
// @author: @anuj0503
class Solution {
    public boolean isNStraightHand(int[] nums, int k) {
        
        int n = nums.length;
        if(n%k != 0) return false;

        Arrays.sort(nums);
        
        Map<Integer, ArrayList<Integer>> indexMap = new HashMap<>();
        
        for(int i = n - 1; i >= 0; i--){
            ArrayList<Integer> al = indexMap.getOrDefault(nums[i], new ArrayList<Integer>());
            al.add(i);
            indexMap.put(nums[i], al);
        }
        
        boolean[] visted = new boolean[n];
        for (int i = 0; i < n; i++){
            if(!visted[i]){
                for(int j = 0; j < k; j++){
                    int num = nums[i] + j;
                    if(indexMap.containsKey(num) && indexMap.get(num).size() > 0){
                        ArrayList<Integer> al = indexMap.get(num);
                        visted[al.get(al.size() - 1)] = true;
                        al.remove(al.size() - 1);
                        indexMap.put(num, al);
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
