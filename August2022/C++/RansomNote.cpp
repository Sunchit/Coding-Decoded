// https://leetcode.com/problems/ransom-note/
class Solution {
public:
    // TC: O(magazine.length() + ransomNote.length())
    // SC: O(26) ~ O(1)
    bool canConstruct(string ransomNote, string magazine) {
        vector<int> letters(26, 0);
        
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine[i];
            letters[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote[i];
            if (letters[c - 'a'] == 0) {
                return false;
            }
            letters[c - 'a']--;
        }
        
        return true;
    }
};
