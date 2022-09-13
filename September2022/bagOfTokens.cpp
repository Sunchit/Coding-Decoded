class Solution {
public:
    int bagOfTokensScore(vector<int>& tokens, int power) {
        
        int score = 0, ans = 0;
        int i = 0, j = tokens.size();
        sort(tokens.begin(),tokens.end());
        while(i<j)
        {
            if(power>=tokens[i])
            {
                power -= tokens[i];
                score++; i++;
                ans = max(ans,score);
            }
            else if(score>0)
            {
                score--; j--;
                power += tokens[j];
            }
            else break;
        }
        return ans;
    }
};
