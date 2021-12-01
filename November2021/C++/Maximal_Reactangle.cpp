class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        if(matrix.size()==0)
            return 0;
        int  r=matrix.size(),c=matrix[0].size();
        int area=0,max=0;
        vector<int> h(c+1,0);
        for(int i=0;i<r;i++)
        {
            stack<int> s;
            for(int j=0;j<c+1;j++)
            {
                if(j<c)
                {    
                    if(matrix[i][j]=='1')
                        h[j]+=1;
                    else
                        h[j]=0;    
                }
                else
                    h[j]=0;
                
                if(s.empty())
                    s.push(j);
                else
                {
                    while(!s.empty() && h[s.top()]>h[j])
                    {
                        int top=s.top();
                        s.pop();
                        area=h[top]*(s.empty()?j:j-s.top()-1);
                        if(area>max)
                            max=area;
                    }
                    s.push(j);
                }
            }
        }
        return max;
        
        
    }
};