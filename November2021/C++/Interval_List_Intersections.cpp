class Solution {
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& firstList, vector<vector<int>>& secondList) {
        vector<vector<int>> res;
        int i=0,j=0;
        while(i<firstList.size() && j<secondList.size())
        {
            if(firstList[i][1]<=secondList[j][1] )
            {
                if( firstList[i][1]>=secondList[j][0])
                {
                    if(firstList[i][0]>=secondList[j][0])
                        res.push_back(firstList[i]);
                    else //if(secondList[j][0]>firstList[i][0])
                        res.push_back({secondList[j][0],firstList[i][1]});
                }
                i++;
            }
            else //if(firstList[i][1]>=secondList[j][1] )
            {
                if(secondList[j][1]>=firstList[i][0])
                {
                    if(firstList[i][0]>=secondList[j][0])
                         res.push_back({firstList[i][0],secondList[j][1]});
                    else //if(firstList[i][0]<secondList[j][0])
                        res.push_back(secondList[j]);
                }
                j++;
            }
        }
        return res;
    }
};