class Solution {
public:
    vector<string> getGrayCode(int m)
    {
        if(m==1)
            return{"0", "1"};
        vector<string> preGrayCode=getGrayCode(m-1);
        int size=preGrayCode.size();
        vector<string> resultant;
        for(auto it: preGrayCode)
            resultant.push_back("0"+it);
        for(int i=size-1; i>=0; i--)
            resultant.push_back("1"+preGrayCode[i]);
        return resultant;
    }
    vector<int> grayCode(int n) {
        vector<string> getCode=getGrayCode(n);
        vector<int> ans;
        for(auto it: getCode)
            ans.push_back(stoi(it,0, 2));
        return ans;
    }
};