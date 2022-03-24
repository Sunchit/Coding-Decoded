
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
