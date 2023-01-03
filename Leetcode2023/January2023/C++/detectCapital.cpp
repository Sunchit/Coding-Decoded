class Solution {
public:
    bool detectCapitalUse(string word) {
        
        int n = word.length();
        int c = 0;
        for(int i=0;i<n;i++)
        {
            if(word[i]>=65 and word[i]<=92) c++;
        }
        if(c==n or c==0 or ((word[0]>=65 and word[0]<=92) and c==1)) return true;
        return false;
    }
};
