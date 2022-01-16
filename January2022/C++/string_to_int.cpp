class Solution {
public:
    int myAtoi(string str) {
        if(str.empty())
            return 0;
        int len = str.length();
        int i = 0; 
        int sign = 1;
        while(i<len && str[i]==' ' )
            i++;
        if(i==len)
            return 0;

        if(str[i]=='-'){
            sign = 0;
            i++;
        }
        else if(str[i]=='+')
            i++;
        long int res = 0;
        while(str[i]>='0' && str[i]<='9'){
            res = res *10;
            if(res >= INT_MAX || res <= INT_MIN)
                break;
            res = res + (str[i]-'0');
            i++;
        }
        if(sign == 0)
            res = -1 * res;
        if(res <= INT_MIN)
            return INT_MIN;
        
        if(res >= INT_MAX)
            return INT_MAX;
        return (int)res;
    }  
};
