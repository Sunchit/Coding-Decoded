// author :shyam25202
// https://leetcode.com/problems/iterator-for-combination/
// discussion post: https://leetcode.com/problems/iterator-for-combination/discuss/789164/C%2B%2B-Using-Bit-manipulation-or-Detail-Explain


class CombinationIterator {
    set<string> res;
    set<string>::iterator curr;
public:
    void generatecombs(string chars,int len)
    {
        int num=1<<chars.size();

        for(int val=1;val<num;val++)
        {
            int j=0;
            string temp="";
            int temp_val=val;
            while(temp_val>0)
            {
                if(temp_val&1)
                    temp+=chars[j];
                
                temp_val>>=1;
                j++;
             
                
            }
            
            if(temp.size()==len)
                res.insert(temp);
        }
    }
    
    CombinationIterator(string characters, int combinationLength) {
       generatecombs(characters,combinationLength); 
        this->curr=begin(res);
    }
    
    string next() {
        return *curr++;
    }
    
    bool hasNext() {
        return curr!=res.end();
    }
};

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator* obj = new CombinationIterator(characters, combinationLength);
 * string param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */