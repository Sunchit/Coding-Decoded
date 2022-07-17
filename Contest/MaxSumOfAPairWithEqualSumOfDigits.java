// https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
// @author: anuj0503
class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, ArrayList<Integer>> digitSum = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++){
            int s = getDigitSum(nums[i]);
            
            digitSum.putIfAbsent(s, new ArrayList<Integer>());
            
            ArrayList<Integer> al = digitSum.get(s);
            al.add(nums[i]);
            
            digitSum.put(s, al);
        }
        
        int result = -1;
        
        for(Map.Entry<Integer, ArrayList<Integer>> entry : digitSum.entrySet()){
            ArrayList<Integer> al = entry.getValue();
            
            if(al.size() == 1) continue;
            
            Collections.sort(al);
            
            result = Math.max(result, al.get(al.size() - 1) + al.get(al.size() - 2));
        }
        
        
        return result;
    }
    
    private int getDigitSum(int n){
        int sum = 0;
        
        while(n != 0){
            sum += n%10;
            n /= 10;
        }
        
        return sum;
    }
}
