class Solution {
public:
    long long calTime(vector<int>& time,long long curr_time)
    {
        long long res=0;
        for(auto& i:time)
        {
             res+=curr_time/i;
        }
        return res;
    }


    long long minimumTime(vector<int>& time, int totalTrips) {
        long double  l=1,r=(long double)(*max_element(begin(time),end(time))) * (long double)totalTrips;
        long long trip=0;
        while(l<r)
        {
            long double  mid =l+(r-l)/2;
            trip=calTime(time,mid);
            if(trip>=totalTrips) r=mid;
            else l=mid+1;
        }
        return (long long)l;
    }
};