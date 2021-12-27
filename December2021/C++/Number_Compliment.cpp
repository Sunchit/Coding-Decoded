class Solution {
public:
    int findComplement(int num) {
        long long  temp=1;
        while(num>=temp)
        {
            num=num^temp;
            temp=temp<<1;
        }
        return num;
    }
};