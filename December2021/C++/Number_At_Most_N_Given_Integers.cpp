class Solution {
public:
    int atMostNGivenDigitSet(vector<string>& digits, int n) {
        int digit=digits.size();
        string number= to_string(n);
        int numbers=number.length(),res=0;
        
        for(int i=1;i<numbers;i++)
            res+=pow(digit,i);
        
        for(int i=0;i<numbers;i++)
        {
            bool hasSameNumber=false;
            for(auto& d:digits)
            {
                if(d[0]<number[i])
                    res+=pow(digit,numbers-i-1);
                else if(d[0]==number[i])
                    hasSameNumber=true;
            }
            if(!hasSameNumber) 
                return res;
        }
        
        return res+1;
    }
};