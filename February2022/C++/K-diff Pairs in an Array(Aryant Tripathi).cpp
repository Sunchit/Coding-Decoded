Brief note about Question-

We have to return the number of unique k-diff pairs in the array.

K- diff pair (arr[i], arr[j]) is nothing but basically

0 < i < j < arr.size()
abs(arr[i] - arr[j]) == k
Solution - I (Accepted)-

We try to implement what the question wants to do, like this is the most basic thing we can do.
We traverse from all of the array and find unique pairs where their absoloute difference is k and increment our count.
See commented program for explanation.
Time Complexity --> O(n ^ 2) // where n is the length of the array
Space Complexity --> O(n) // as we are using map to store pairs
It paases [ 60 / 60] in built test cases
Code (C++)

class Solution {
public:
    int findPairs(vector<int>& arr, int k) {
        int n = arr.size(); // take the size of the array
        int count = 0; // variable to store count
        
        sort(arr.begin(), arr.end()); // sort the array to find unique pairs
        map<pair<int,int>, int> mp; // make a map where key is pair & value if it occurs
        
        for(int i = 0; i < n - 1; i++) // traverse from the whole array
        {
            for(int j = i + 1; j < n; j++)
            {
                if(abs(arr[j] - arr[i]) == k) // if it follows criteria
                {
                    // make a pair to find whether it is unique or not
                    pair<int,int> p = {arr[i], arr[j]}; 
                    
                     // if this pair not present in the map, then we do the computation
                    if(mp.find(p) == mp.end())
                    {
                        count++; // increment count
                        mp[p] = 1; // make its value as 1, saying that now it is present in our map
                    }
                }
            }
        }
        return count; // and at last return the count
    }
};
Solution - II (Accepted)-

So a question arises can we optimise it.
And answer is yes, but how?
See, we have to find number of unique pairs such that their absoloute difference is k.
suppose, a - b == k --> a = b + k
Can't we store all the values of array into a map and then for every value we find value + k.
That's all we have to do.
see commented code for more explanation.
Time Complexity --> O(n) // where n is the length of the array
Space Complexity --> O(n) // as we are using unordered map to store pairs
It paases [ 60 / 60] in built test cases
Code (C++)

class Solution {
public:
    int findPairs(vector<int>& arr, int k) {
        int n = arr.size(); // take the size of the array
        unordered_map<int, int> mp; // map to store all values of array
        
        for(int i = 0; i < n; i++) //store all values of array into map
        {
            mp[arr[i]]++;
        }
        
        int count = 0; // variable to store the unique pairs
        
        if(k != 0) // if k is not zero
        {
            for(auto it = mp.begin(); it != mp.end(); it++) // traverse in all over the map
            {
                // if value + k is present in map
                if(mp.find(it -> first + k) != mp.end())
                {
                    count++; // increment count
                }
            }
        }
        else // see for k = 0, we have to just find all the values greater than 1
        {
            for(auto it = mp.begin(); it != mp.end(); it++)
            {
                if(it -> second > 1)
                {
                    count++;
                }
            }
        }
        
        return count; // at last return count
    }
};