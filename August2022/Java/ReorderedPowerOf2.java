// @saorav21994

/* naive
class Solution {
    public boolean reorderedPowerOf2(int n) {
        
        // 2^30 > 10^9
        
        Set<String> hash = new HashSet<>();
        
        for (int i = 0; i <= 30; i++) {
            int pow = (int)Math.pow(2, i);
            char [] ch = String.valueOf(pow).toCharArray();
            Arrays.sort(ch);
            String s = String.valueOf(ch);
            hash.add(s);
            // System.out.println("s = " + s);
        }
        
        char [] val = String.valueOf(n).toCharArray();
        Arrays.sort(val);
        // System.out.println("val = " + String.valueOf(val));
        if (hash.contains(String.valueOf(val)))
            return true;
        return false;
    }
}
*/

/* Leetcode solution */

class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[] A = count(N);
        for (int i = 0; i < 31; ++i)
            if (Arrays.equals(A, count(1 << i)))
                return true;
        return false;
    }

    // Returns the count of digits of N
    // Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
    public int[] count(int N) {
        int[] ans = new int[10];
        while (N > 0) {
            ans[N % 10]++;
            N /= 10;
        }
        return ans;
    }
}
