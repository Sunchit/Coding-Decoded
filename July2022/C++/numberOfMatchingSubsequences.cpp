class Solution {
public:
    int numMatchingSubseq(string s, vector<string>& words) {
        
        unordered_map<char,vector<int>> m; // map for storing the all indices of characters in string s 
        int i = 0;
        for(auto &x : s)
            m[x].push_back(i++);
        
        int ans = 0;
        for(int i=0;i<words.size();i++)  // Looping over the words for cheking the subsequences
        {
            string x = words[i];
            int prev = -1;
            for(int j=0;j<x.length();j++)
            {
                auto it = upper_bound(m[x[j]].begin(),m[x[j]].end(),prev); // Finding the index just greater than prev in words of string  
                if(it==m[x[j]].end()) break;
                prev = *it;
                
                if(j==x.length()-1) ans++;
            }
        }
        return ans;
    }
};
