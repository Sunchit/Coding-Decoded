// https://leetcode.com/problems/minimum-deletions-to-make-array-divisible/
// @author: anuj0503
class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int gcd = numsDivide[0];
        
        if(numsDivide.length != 1)
            gcd = findGCD(numsDivide, numsDivide.length);
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], 0);
            
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        
        int result = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            
            if(gcd%key == 0){
                return result;
            }
            
            result += val;
        }
        
        return -1;
        
    }
    
    
    private int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    private int findGCD(int arr[], int n)
    {
        int result = arr[0];
        for (int element: arr){
            result = gcd(result, element);
 
            if(result == 1)
            {
               return 1;
            }
        }
 
        return result;
    }
}
