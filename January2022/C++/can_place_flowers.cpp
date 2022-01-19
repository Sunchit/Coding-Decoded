created by @pranav108
class Solution {
public:
    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int temp=0,i=0,len=flowerbed.size();
        while(i<len&&flowerbed[i]==0)
            i++;
        if(i==len)
            return (len+1)/2>=n;
        n-=i/2;
        for(;i<len&&n>0;i++){
            if(flowerbed[i]){
                n-=temp>2?(temp-1)/2:0;
                    temp=0;
            }else
                temp++;
        }
        n-=temp/2;
        return n<=0;
    }
};
