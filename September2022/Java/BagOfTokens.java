
// @saorav21994
// TC : O(nlogn)
// SC : O(1)

class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        Arrays.sort(tokens);
        int s = 0;
        int n = tokens.length;
        if (n == 0) {
            return s;
        }
        else if (tokens[0] > P) {
            return s;
        }
        else {
            int i = 0, j = n-1;
            while (i <= j) {
                if (tokens[i] <= P) {
                    P -= tokens[i];
                    s += 1;
                    i += 1;
                }
                else {
                    if (i < j && s > 0) {
                        P += tokens[j];
                        j -= 1;
                        s -= 1;
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return s;
        
    }
}
