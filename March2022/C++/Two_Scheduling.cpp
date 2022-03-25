class Solution {
public:
    int twoCitySchedCost(vector<vector<int>>& costs) {
        int res=0,a,b,a_count=0,b_count=0,n=costs.size();
        pair<int,int> temp;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> qa;
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> qb;
        
        for(int i=0;i<n;i++)
        {
            a=costs[i][0];
            b=costs[i][1];
            if(a<b)
            {
                a_count++;
                res+=a;
                qa.push({abs(a-b),i});
            }
            else
            {
                b_count++;
                res+=b;
                qb.push({abs(a-b),i});
                
            }
            
            if(a_count>n/2)
            {
                
                temp=qa.top();
                qa.pop();
                a_count--;
                b_count++;
                res+=(costs[temp.second][1]-costs[temp.second][0]);
                qb.push(temp);
            }
            else if(b_count>n/2)
            {
               
                temp=qb.top();
                qb.pop();
                a_count++;
                b_count--;
                res+=(costs[temp.second][0]-costs[temp.second][1]);
                qa.push(temp);
            }
                

        }
        return res;
    }
};