// https://leetcode.com/problems/count-of-smaller-numbers-after-self/
// @author: anuj0503
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] result = new Integer[n];
        ArrayList<Integer> al = new ArrayList<>();
        
        // Last index will always have 0 greater elements in right
        result[n - 1] = 0;
        
        // maintaining a sorted list of the elements traverse till now.
        al.add(nums[n-1]);
        
        // Starting from reverse order
        for(int i = n - 2; i >= 0; i--){
            // get the lower bound
            int index = getIndex(al, nums[i]);
            
            // adding traversed element in the sorted array.
            al.add(index, nums[i]);
            result[i] = index;
        }
        
        return Arrays.asList(result);
    }
    
    // Binary Search for lower bound.
    private int getIndex(ArrayList<Integer> al, int num){
        int low = 0, high = al.size() - 1;
        
        while(low < high){
            int mid = low + (high - low)/2;
            
            if(al.get(mid) < num){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        if(low < al.size() && al.get(low) < num) low++;
        
        return low;
    }
}
