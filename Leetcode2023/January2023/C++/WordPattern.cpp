// https://leetcode.com/problems/word-pattern/
class Solution {
private:
    vector<string> split(string& s) {
        vector<string> list;
        string word = "";
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == ' ') {
                list.push_back(word);
                word.clear();
                continue;
            }
            word += s[i];            
        }
        list.push_back(word);
        return list;
    }
    
public:
    // TC: O(n)
    // SC: O(n)
    bool wordPattern(string pattern, string s) {
        vector<string> words = split(s);
        
        if (pattern.length() != words.size()) {
            return false;
        }
        
        unordered_map<char, string> map;
        unordered_set<string> set;    
        
        for(int i = 0; i < pattern.length(); i++) {
            string word = words[i];
            char ch = pattern[i];
            
            
            if(map.find(ch) != map.end()) {
                if(map[ch] != word) {
                    return false;
                }
            } else {
                if(set.find(word) != set.end()){
                    return false;
                } else {
                    set.insert(word);
                    map[ch] = word;
                }
            }
        }
        
        return true;        
    }
};

