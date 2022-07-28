class Solution {
public:
    // TC: O(n)
    // SC: O(26) -> O(1)
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) {
            return false;
        }
        
        vector<int> letters(26, 0);
        
        char c1, c2;
        for (int i = 0; i < s.size(); i++) {
            c1 = s[i];
            c2 = t[i];
            
            letters[c1 - 'a']++;    // incrementing the char count  
            letters[c2 - 'a']--;    // decrementing the char count
        }
        
        // if they are anagram then the array should contain 0 value
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
};
