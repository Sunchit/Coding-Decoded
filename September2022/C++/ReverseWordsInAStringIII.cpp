// https://leetcode.com/problems/reverse-words-in-a-string-iii/
class Solution {
private:
    void reverse(int start, int end, string& s) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
public:
    // TC: O(n)
    // SC: O(1)
    string reverseWords(string s) {
        int n = s.length();
        int start = 0;
        int end = 0;
        
        while (end < n) {
            while (end < n && s[end] != ' ') {
                end++;
            }
            reverse(start, end - 1, s);
            end++;
            start = end;
        }
        
        return s;
    }
};
