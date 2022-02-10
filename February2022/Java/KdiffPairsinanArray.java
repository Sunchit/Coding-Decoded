
// @saorav21994
// TC:  O(n)
// Medium

/*
  Similar approach as sum of 2 nummber to a given sum in an array. Special case of (k == 0) -> check for frequency of the number >= 2 as only (x-x) will give 0.
*/


class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums) {
        	map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int pairs = 0;
        
        for (Integer key : map.keySet()) {
        	int mapVal = map.getOrDefault(key+k, 0);
            if (k == 0) {
                if (mapVal > 1)
                    pairs += 1;
            }
            else {
                if (mapVal > 0)
                    pairs += 1;
            }
        	
        }
        
        return pairs;
        
    }
}

// Problem : https://leetcode.com/problems/k-diff-pairs-in-an-array/
// @romitdutta10
// TC : O(n)
// Another Approach with two sets

class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
    
        Set<String> pairs = new HashSet<>();
        
        Set<Integer> visited = new HashSet<>();
        
        for(int num : nums) {
            int greater = num + k;
            int lesser = num - k;
            
            if(visited.contains(greater)) {
                pairs.add(num + " " + greater);
            }
            if(visited.contains(lesser)) {
                pairs.add(lesser + " " + num);
            }
            
            visited.add(num);
        }
        
        return pairs.size();
    }
}

// Problem : https://leetcode.com/problems/k-diff-pairs-in-an-array/
// @romitdutta10
// TC : O(nlogn)
// Solution with O(1) space 

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0,right=1;
        int ans=0;
        
        while(left<nums.length && right<nums.length)
        {
            if(left==right || nums[right] - nums[left] < k)
                right++;
            
            else if(nums[right] - nums[left] > k)
                left++;
            else
            {
                left++;
                ans++;
                while(left<nums.length && nums[left] == nums[left-1])
                {
                    left++;
                }
            }
            
            
        }
        return ans;
    }
}
