/*
* @author : Darshika Jha
* Question Link : https://leetcode.com/problems/count-vowels-permutation/
*/

class Solution {
    public int countVowelPermutation(int n) {
        if(n == 1){
            return 5;
        }
        long a = 1;
        long e = 1;
        long i = 1;
        long o = 1;
        long u = 1;
        int mod = 1000000007;
        for(int j =2;j<=n;j++){
            long na = 0;
            long ne = 0;
            long ni = 0;
            long no = 0;
            long nu = 0;
            na = (e + i + u) % mod ;
            ne = (a + i) % mod;
            ni = (e + o) % mod;
            no = i % mod;
            nu = (i + o) % mod;
            a = na;
            e = ne;
            i = ni;
            o = no;
            u = nu;
        }
        
        return (int)((a + e + i + o + u)% mod);
        
    }
}
