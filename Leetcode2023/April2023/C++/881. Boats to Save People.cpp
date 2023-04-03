class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
     
        int n = people.size();
        int l = 0, h = n-1, ans = 0;
        sort(people.begin(), people.end());
        
        while(l<=h)
        {
            if(people[l]+people[h]<=limit) l++;
            
            h--;
            ans++;
        }
        return ans;
    }
};
