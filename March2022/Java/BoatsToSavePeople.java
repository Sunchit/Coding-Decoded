
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = people.length;
        int s = 0, e = l-1;
        int res = 0;
        while (s <= e) {
            int d = limit - people[e];
            if (d >= people[s]) {
                s += 1;          
            }
            res += 1;
            e -= 1;
        }
        return res;
    }
}

// Author: @romitdutta10
// TC : O(nlogn)
// SC : O(1)
// Problem : https://leetcode.com/problems/boats-to-save-people/ 

class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        
        int start = 0;
        int end = people.length - 1;
        int res = 0;
        
        while(start <= end) {
            if(people[start] + people[end] <= limit) {
                
                start++;
            } 
            end--;
            res++;
            
        }
        
        return res;
    }
}
