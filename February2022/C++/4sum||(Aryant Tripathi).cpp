Brief note about Question-

We have to count tuples such that -

nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
where 0 <= i, j, k, l < n and n is the length of each array

Solution - I (Most basic approach, TLE)

Okay, so the most basic approach we can think of is, we are are obedient person, and not to do anything extra from ourself,
we simply do, what the question wants us to do, i.e we run four(4) loops naming i, j, k, l by trying out every possiblity and when we get our sum as zero, simply we increment our count.
So, obviously it gives us TLE, but no problem we will find a way to optimise it further,
therefore,

Time Complexity --> O(n ^ 4) &
Space Complexity --> O(1)
It paases [ 20 / 132 ] in built test cases
Code (C++)

class Solution {
public: 
    int fourSumCount(vector<int>& arr1, vector<int>& arr2, vector<int>& arr3, vector<int>& arr4) {
        int n = arr1.size();// since length of all arrays are same,so we called it  as 'n'
        
        int count = 0; // to count our tuples
        
        // running 4 loops
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                {
                    for(int l = 0; l < n; l++)
                    {
                        if(arr1[i] + arr2[j] + arr3[k] + arr4[l] == 0)
                        {
                            count++; // everytime we got an answer increment count
                        }
                    }
                }
            }
        }
        
        return count;
    }
};
Solution - II (Further Optimisation but still TLE)

After getting TLE, Now, we want to become a good programmer, therefore we start thinking that how we may optimise it, so on observing carefully, we came to a conclusion that, why not try to store array 4 somewhere from which we don't have to run an extra loop, so we will use an unordered map.

So, we will use a map and store all the elements of 4th array and after running three loops we will check whether the remainng value is present in our map or not.

so A question arises why, why we use an unordered map ?
Ans - we use an unordered map to store all the elements of 4th array and use find function to find the remaining element as the Time complexity of find function in an unordered map is O(1) on average, so this will reduce a burden of an extra loop from us.
therefore,

Time Complexity is --> O(n ^ 3)&
Space Complexity is --> O(n) (As we use an unordered map to store the elemnts of 4th array)
It passes [53 / 132] in built test cases
Code (C++)

class Solution {
public: 
    int fourSumCount(vector<int>& arr1, vector<int>& arr2, vector<int>& arr3, vector<int>& arr4) {
        int n = arr1.size();// since length of all arrays are same,so we called it  as 'n'
        
        int count = 0; // to count our tuples
        
        // make an unordered_map to store elements of 4th array
        unordered_map<int, int> mp;
        for(int i = 0; i < n; i++)
        {
            mp[arr4[i]]++; // storing elements
        }
        
        // running 3 loops
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                {
                    // remaining element to find out
                    int remaining = 0 - (arr1[i] + arr2[j] + arr3[k]);
                    
                    // if element is present
                    if(mp.find(remaining) != mp.end())
                    {
                        // add element in our count that how many times it is present in our map
                        count += mp[remaining];
                    }
                }
            }
        }
        
        return count; // simply return count
    }
};
Solution - III (Further Optimisation and yes correct answer)

Aah, We try Hard but still we got TLE, okay no problem, we are hardworking guy, we will find a way to make it AC.

So, again we start thinking to our previous soloution, what we may further do to optimise it. And Now at this staze we know that O(n ^ 3) not worked so we have to do it in O(n ^ 2) and also we know this using unordered map we can do it.

Now, We think instead of just storing all the elements of 4th array, may we are able to store some more elements to it, and we conclude that yes!!, first we will store the sum of first two arrays in our unordered map and then we will use a very basic maths type thing.

See, We have to find the number of tuples such that

nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
-> nums1[i] + nums2[j] == -(nums3[k] + nums4[l])
that's it, we have to just do this,

So, On concluding, what we will have to do?

Store sum of first and second array in our unordered map.
Then just multiply by -1 we have to find that whether sum of third and fourth array is present in map or not,
If present then simply increase the count
simply return the count.
Therefore,
Time Complexity --> O(n ^ 2) &
Space Complexity --> O(n) (As we use an unordered map to store the sum of elements of first two arrays)
It paases [ 132 / 132 ] in built test cases
Code (C++)

class Solution {
public:
    int fourSumCount(vector<int>& arr1, vector<int>& arr2, vector<int>& arr3, vector<int>& arr4) {
        int n = arr1.size();// since length of all arrays are same,so we called it  as 'n'
        
        // make an unordered map to store sum of first and second array into the map
        unordered_map<int,int> mp;
           
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                int sum = arr1[i] + arr2[j];
                mp[sum]++; // storing sum of first and second array
            }
        }
        
        int count = 0; // variable count which gives us  number of tuples
        
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                // make a variable to find from third and fourth array
                int to_find = -1 * (arr3[i] + arr4[j]);
                
                // if this present in our map
                if(mp.find(to_find) != mp.end())
                {
                    // add in our count that how many times it is present in our map
                    count += mp[to_find];
                }
            }
        }
        
        return count; // simply return count
    }
};
