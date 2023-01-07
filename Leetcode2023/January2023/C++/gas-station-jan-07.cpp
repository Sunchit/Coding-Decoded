class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        
        int n = gas.size();
        int total_gas = 0, total_cost = 0;
        total_gas = accumulate(gas.begin(),gas.end(),total_gas);
        total_cost = accumulate(cost.begin(),cost.end(),total_cost);

        if(total_gas<total_cost) return -1;
        
        int start = 0, current = 0;
        for(int i=0;i<n;i++)
        {
            current += (gas[i] - cost[i]);
            if(current<0)
            {
                start = i+1;
                current = 0;
            }
        }
        return start;
    }
};
