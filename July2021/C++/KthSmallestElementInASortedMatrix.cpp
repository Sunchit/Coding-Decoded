class Solution
{
public:
    int kthSmallest(vector<vector<int>> &matrix, int k)
    {
        vector<int> vect_1D;
        for (vector<int> row : matrix)
            for (auto element : row)
                vect_1D.push_back(element);
        sort(vect_1D.begin(), vect_1D.end());
        return vect_1D[k - 1];
    }
};