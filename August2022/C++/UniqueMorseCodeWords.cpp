class Solution {    
public:
    // TC: O(n * m) -> n = words.length, m = words[i].length
    // SC: O(n) 
    int uniqueMorseRepresentations(vector<string>& words) {
        unordered_set<string> set;
        string morseTable[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        for (string &word : words) {
            string code = "";
            for (char &c : word) {
                int index = c - 'a';
                code += morseTable[index];
            }
            set.insert(code);
        }

        return set.size();
    }
};
