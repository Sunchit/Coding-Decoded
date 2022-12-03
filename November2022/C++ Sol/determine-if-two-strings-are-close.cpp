class Solution {
public:
    bool closeStrings(string word1, string word2) {
        
        int n = word1.size();
        
        if(n!=word2.size()){
            return false;
        }
        
       vector<int>freq1(26,0);
        vector<int>freq2(26,0);
        map<int,int>freqWord1;
        map<int,int>freqWord2;
        
        // word1 ->   a->  3   b-> 2 c->5
        // word2 ->  a-> 5  b->3  c-> 1
        
        
        for(int i=0; i<n;i++){
            freq1[word1[i]-'a']++;
        }
        
          for(int i=0; i<n;i++){
            freq2[word2[i]-'a']++;
        }
        
        
        for(int i=0;i<26;i++){
            if(freq1[i]>0 && freq2[i] == 0){
                return false;
            }
             if(freq2[i]>0 && freq1[i] == 0){
                return false;
            }
            freqWord1[ freq1[i]]++;
        
            freqWord2[ freq2[i]]++;
        }
        
        for(auto num:freqWord1){
    
            if(num.second!= freqWord2[num.first]){
                return false;
            }
        }
        
        
        return true;
    }
};