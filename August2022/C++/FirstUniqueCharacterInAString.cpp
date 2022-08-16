class Solution {
public:
    // TC: O(n)
    // SC: O(26) ~ O(1)
    int firstUniqChar(string s) {
        int letters[26] = {0};        
        char c;
        for (int i = 0; i < s.size(); i++) {
            c = s[i];
            letters[c - 'a']++;
        }
        
        for (int i = 0; i < s.size(); i++) {
            c = s[i];
            if (letters[c - 'a'] == 1) {
                return i;
            }
        }
        
        return -1;
    }
};
