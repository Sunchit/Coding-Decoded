class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        
        sort(potions.begin(),potions.end());
        vector<int> ans;
        
        int m = potions.size();
        for(int i=0;i<spells.size();i++)
        {
            int l = 0, h = m-1;
            int res = m;
            
            while(l<=h)
            {
                int mid = (l+h)/2;
                if( (1LL*potions[mid]*spells[i]) >=success )
                {
                    res = mid;
                    h = mid-1;
                }
                else l = mid+1;
            }
            ans.push_back(m-res);
            
        }
        return ans;
    }
};
