//Series on the horizontal goes till infinity
//        n = 1 series is
//        n = 2 series is 1 3 5 7 9 11 13 15 17 19 21 23 25 27 => 1 + (1 +2 +3 ...)*2 + k = T, T = 1 + 2 + 3 ...infinty
//        n = 3 series is 1 3 7 9 13 15 19 21 25 27
//        n = 4 series is 1 3 7 13 15 19 25 27
//        n = 5 series is 1 3 7 13 19 25 27
//        n = 6


public class Solution {
  //  Remove every 2nd el 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
  //  Remove every 3rd el 1 3 5 7 9 11 13 15 17 19 21
  //  Remove every 4th el 1 3 7 9 13 15 19 21
  //  Remove every 4th el 1 3 7 15 19 21

    static int mod = 1;

    private boolean willItSurvive(int k){
    // n =3

        // k = 2x + 3y+ 4z + 5t......

        // f(n) = f(n-1) %n
        if(k<mod) {
            return false;

        } else if(k % mod == 0){
            return true;

        }  else {
                mod++;
                return willItSurvive(k - k/mod);
                
        }
    }
}
