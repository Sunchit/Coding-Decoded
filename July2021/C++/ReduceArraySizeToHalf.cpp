class Solution
{
public:
    int minSetSize(vector<int> &arr)
    {
        map<int, int> counter;
        for (auto a : arr)
            counter[a]++;
        priority_queue<int> q;
        for (auto c : counter)
            q.push(c.second);
        int removed = 0, res = 0;
        while (removed < arr.size() / 2)
        {
            removed += q.top();
            q.pop();
            res++;
        }
        return res;
    }
};