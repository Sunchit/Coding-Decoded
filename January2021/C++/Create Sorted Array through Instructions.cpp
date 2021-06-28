/**
 * @author ssrbazpur
 * Time Complexity: O(NlogN) where N is the number of elements in instructions array
 * Space Comlexity: O(N)
 */

class Fenwick
{

public:
    vector<int> a;

    Fenwick(int len)
    {
        a = vector<int>(len, 0);
    }

    //[2,3]--> sum(4)-sum(2)=0+1+2+3 - 0+1
    int sumRange(int beg, int end)
    {
        return sum(end + 1) - sum(beg);
    }

    int sum(int index)
    {
        int ans = 0;
        while (index > 0)
        {
            ans = ans + a[index];
            //get Last Set bit by index & - index

            index = index - (index & -index);
        }
        return ans;
    }

    void update(int index, int val)
    {

        index++;
        while (index < a.size())
        {
            a[index] = a[index] + val;
            index = index + (index & -index);
        }
        // for (int i : a)
        // {
        //     cout << i;
        // }
        // cout << endl;
    }
};

class Solution
{
public:
    int createSortedArray(vector<int> &instructions)
    {

        //Getting what should be the max of Array to build the Fenwick Tree
        int max = 0;
        for (int i : instructions)
        {
            if (i > max)
            {
                max = i;
            }
        }

        Fenwick tree = Fenwick(max + 2);

        int ans = 0;
        for (int i = 0; i < instructions.size(); i++)
        {

            int curr = instructions[i];
            int lower = tree.sumRange(0, curr - 1);
            int higher = tree.sumRange(curr + 1, max);
            ans += min(lower, higher);
            ans = ans % 1000000007;
            tree.update(curr, 1);
        }
        return ans;
    }
};