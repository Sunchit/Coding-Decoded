class Solution
{
public:
    string customSortString(string order, string str)
    {
        string ans = "";
        map<char, int> m;
        for (auto x : str)
        {
            m[x]++;
        }
        for (auto x : order)
        {
            if (m.find(x) != m.end())
            {
                auto temp = m.find(x);
                int count = temp->second;
                ans += string(count, x);
                m.erase(x);
            }
        }
        for (auto x : m)
        {
            ans += string(x.second, x.first);
        }
        return ans;
    }
};