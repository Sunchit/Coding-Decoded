// @Sarang661
class Solution {
public:
    string reverseVowels(string s) {
        int total_size = s.size();

        int start = 0;
        int end = total_size-1;

        set<char>st;
        st.insert('a'),  st.insert('e'),  st.insert('i'),  st.insert('o'),  st.insert('u');
    st.insert('A'),  st.insert('E'),  st.insert('I'),  st.insert('O'),  st.insert('U');
        while(start<end){

            while(start<end && st.find(s[start])==st.end()){
                start++;
            }

             while(start<end && st.find(s[end])==st.end()){
                end--;
            }
           
            swap(s[start],s[end]);
            start++;
            end--;
        }

        return s;
    }
};