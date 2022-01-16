class Solution {
public:
    int maxDistToClosest(vector<int>& seats) {
        int ans=0,n=seats.size(),temp=0,lead=0,i =0;
        while(i<n&&seats[i]!=1){
            lead++;
            i++;
        }
        for(;i<n;i++){
            if(seats[i]==0){
                temp++;
                ans=max(ans,temp);
            }else
                temp=0;
        }
        return max((ans+1)/2,max(temp,lead));
    }
};
