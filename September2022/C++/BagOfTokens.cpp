// https://leetcode.com/problems/bag-of-tokens/
class Solution {
public:
    // TC: O(nlogn)
    // SC: O(1)
    int bagOfTokensScore(vector<int>& tokens, int power) {
        int score = 0;
        int maxScore = 0;
        
        // sort tokens in ascending order
        sort(tokens.begin(), tokens.end());
        
        int left = 0;
        int right = tokens.size() - 1;
        
        while (left <= right) {
            if (power >= tokens[left]) {                // option 1
                power -= tokens[left];
                score++;
                left++;
                maxScore = max(maxScore, score);
            } else if (left != right && score >= 1) {   // option 2
                power += tokens[right];
                score--;
                right--;
            } else {
                break;
            }
        }
        
        return maxScore;
    }
};
