class Solution {
public:
    bool valid_capacity(vector<int>& weights,int days,int capacity)
    {
        int total_days=0;
        int curr_cap=0;
        for(auto& i:weights)
        {
            if(curr_cap+i<=capacity) curr_cap+=i;
            else
            {
                total_days++;
                curr_cap=i;
            }
        }

        return total_days+1<=days;
    }

    int shipWithinDays(vector<int>& weights, int days) {
        int sum=0,min_cap=weights[0];
        for(auto& i:weights)
        {
            sum+=i;
            min_cap=max(min_cap,i);
        }
        int l=min_cap,r=sum,mid;
        while(l<r)
        {
            mid=l+(r-l)/2;
            if(valid_capacity(weights,days,mid)) r=mid;
            else l=mid+1;
        }

        return l;

    }
};