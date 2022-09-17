class Solution {
public:
    vector<int> findNumOfValidWords(vector<string>& words, vector<string>& puzzles) {
            unordered_map<char,vector<int>> dict;
            for(int i=0;i<26;i++)
            {
                vector<int> v;
                dict[(char)(i+'a')]=v;
            }
        
        for(auto& word:words)
        {
            int mask{};
            
            for(auto& ch:word)
            {
                int bit =ch-'a';
                mask=mask|1<<bit;
            }
            
            vector<int> rep(26,0);
            for(auto& ch:word)
            {
                
                if(!rep[ch-'a'])
                {
                    dict[ch].push_back(mask);
                    rep[ch-'a']=1;
                }
            }
        }
        vector<int> ans;
        for(auto& puzzle :puzzles)
        {
            int cnt{};
            char firstchar=puzzle[0];
            int mask{};
            
            for(auto& ch:puzzle)
            {
                int bit=ch-'a';
                mask=mask|1<<bit;
            }
            
            // vector<int> res=dict[firstchar];
            for(auto& wrd:dict[firstchar])
            {
                if((mask&wrd)==wrd)
                    cnt++;
            }
            ans.push_back(cnt);
                
        }
        return ans;
        
    }
};