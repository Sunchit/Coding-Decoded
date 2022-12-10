class Solution {
public:
    bool halvesAreAlike(string s) {
        
        int num = 0;
        int len = s.size();
       int val1 = 0;
        set<char>st;
        st.insert('a'),  st.insert('e'),  st.insert('i'),  st.insert('o'),  st.insert('u');
                st.insert('A'),  st.insert('E'),  st.insert('I'),  st.insert('O'),  st.insert('U');
        
        for(int index =0;index < len; index++){
            if(st.find(s[index])!=st.end()){
                num++;
                if(index<len/2){
                    val1++;
                }
            }
        }
    
        return num%2==0 && val1==num/2;
    }
};