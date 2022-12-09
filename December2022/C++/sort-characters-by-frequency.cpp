class Solution {
public:
    string frequencySort(string s) {
                map<char,int>freq;
        
        int len = s.size();
        
        for(int index = 0; index < len; index++){
            freq[s[index]]++;
        }
        
        vector<pair<int,char>>sorted;
        
        
        for(auto num:freq) {
            sorted.push_back({num.second,num.first});
        }
        
        sort(sorted.begin(),sorted.end());
        
        string ans = "";
        
        for(int index = sorted.size()-1; index >= 0; index--){
            int currFreq = sorted[index].first;
            char currChar = sorted[index].second;
            
            while(currFreq>0){
                ans+=currChar;
                currFreq--;
            }
        }
        
        return ans;
    }
};