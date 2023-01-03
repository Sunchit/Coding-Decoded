class Solution {
public:
    int minDeletionSize(vector<string>& strs) {
        
        int n = strs.size();
        int c = 0;
        for(int i=0;i<strs[0].size();i++)
        {
            int f = 0;
            for(int j=0;j<n-1;j++)
            {
                if(strs[j][i]>strs[j+1][i]) {f = 1; break;}
            }
            if(f) c++;
        }
        return c;
    }
};
