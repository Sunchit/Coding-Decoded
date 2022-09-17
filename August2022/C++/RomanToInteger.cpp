class Solution {
public:
    // TC: O(n)
    // SC: O(1)
    int romanToInt(string s) {
        unordered_map<char, int> map;
        map['I'] = 1;
        map['V'] = 5;
        map['X'] = 10;
        map['L'] = 50;
        map['C'] = 100;
        map['D'] = 500;
        map['M'] = 1000;
        
        int num = 0;
        
        int currNum;
        char c, nextChar;        
        for (int i = s.size() - 1; i >= 0; i--) {
            c = s[i];
            currNum = map[c];
            
            if (i != s.size() - 1) {
                nextChar = s[i + 1];
                
                if (c == 'I' && (nextChar == 'V' || nextChar == 'X')) {
                    num -= currNum;
                } else if (c == 'X' && (nextChar == 'L' || nextChar == 'C')) {
                    num -= currNum;
                } else if (c == 'C' && (nextChar == 'D' || nextChar == 'M')) {
                    num -= currNum;
                } else {
                    num += currNum;
                }
            } else {
                num += currNum;
            }
        }
        
        return num;
    }
};
