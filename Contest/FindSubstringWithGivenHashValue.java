class Solution {
    // TC : O(n)
    // SC: O(1)
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {

        long powerK_1 = 1;
        int p = k-1;
        while(p>0){
           powerK_1 = (powerK_1 * power) % modulo;
            p--;
        }

       int index = 0;
       int end = s.length() - 1;

        long hash = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            int sVal = s.charAt(i) - 'a' + 1;

            hash = (hash * power % modulo + sVal) % modulo;

            if (end - i + 1 == k) {
                if (hash == hashValue) {
                    index = i;
                }
                hash = (hash - (s.charAt(end) - 'a' + 1)
                        * powerK_1 % modulo + modulo) % modulo;
                end--;
            }
        }

        return s.substring(index, index+k);
    }
}