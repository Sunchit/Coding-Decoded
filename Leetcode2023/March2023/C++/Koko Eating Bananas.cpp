class Solution {
public:

    int getHours(vector<int>& piles,int speed)
    {
        int totalHours=0;
        for(auto& i:piles)
        {
            if(i%speed){
                totalHours+=(i/speed) + 1 ;
            }
            else totalHours+=i/speed;
        }
        return totalHours;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int l=1,r=*max_element(begin(piles),end(piles));

        int mid;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(getHours(piles,mid) > h ) l=mid+1;
            else r=mid;
        }
        return l;

    }
};