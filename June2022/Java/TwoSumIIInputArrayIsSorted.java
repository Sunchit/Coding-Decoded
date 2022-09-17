
// @saorav21994
// TC : O(n)
// SC : O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, h = n-1;
        while (l < h) {
            int sum =  numbers[l] + numbers[h];
            if (sum == target)
                return new int[] {l+1, h+1};
            else if (sum < target) {
                l += 1;
            }
            else {
                h -= 1;
            }
        }
        return new int[] {-1,-1};
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length-1;
        while(start<end){
            if( numbers[start] + numbers[end] == target){
                int[] ans = new int[] { start+1, end+1};
                return ans;
            } else if(numbers[start] + numbers[end] < target){
                start++;
            } else {
                //numbers[start] + numbers[end] > target
                end--;
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0;i<nums.length;i++){
            int el = nums[i];
            if(map.containsKey(target-el)){
                // 4 2
                if(map.get(target-el)!=i)
                {   ans[0] = map.get(target-el)+1;
                    ans[1] = i+1;
                    break;
                }
            }
            map.put(el,i);
        }
        return ans;

    }
}