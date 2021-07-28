class MedianFinder
{
public:
    /** initialize your data structure here. */
    //vector<int> v;
    multiset<int> m;
    MedianFinder()
    {
        m.clear();
    }

    void addNum(int num)
    {

        m.insert(num);
    }

    double findMedian()
    {

        int n = m.size();
        auto itr = m.begin();
        advance(itr, n / 2);
        auto itr2 = itr--;
        //auto itr2= itr--;
        double ans;
        double num1 = (*itr);
        if (n % 2)
        {

            ans = (num1);
        }
        else
        {

            double num2 = (*itr2);
            ans = (num1 + num2) / 2;
        }
        return ans;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */