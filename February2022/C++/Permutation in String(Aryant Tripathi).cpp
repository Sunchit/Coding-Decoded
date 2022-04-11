Brief note about Question-

We have to return true if one of s1's permutations is the substring of s2.
Let's take an example not given in the question -
suppose our s1 : "aabcd" and s2 : "abkdabadcxyab"
                                       ↑↑↑↑↑
									   
So, the answer should be true because s2 conatains a permutation of s1 i.e (abadc)
Solution - I (Sliding window, Accepted)-

Now, the most basic thing we can do is, first we generate every permutaion of s1 and for each permutation we traverse string s2 every time and find whether one of the permutation is exist in our s2 or not. If anyone of the permutaion exist then return true otherwise return false.
So yes, obviosuly we are not going to do that. Instead of doing all that hectic work, we start observing our question.
If the length of string s2 is less than the length of string s1, so we will suddenly return false saying that it is impossible to find any permutation of s1 in s2.
First thing that we can observe is, any of the permutation of s1 is the same length as of s1, right na.
So, it gives us our first hint that in the string s2, we will check all of the windows that is same as of length s1, because we know answer will exist then only.
Now, the second and most important thing that we can observe is, no matter what will be the permutation of s1, the frequency of every character of s1 is same in all of its permutation.
So, Importantly we have to do two things-

We travel in s2, and for the window size that is equal to the length of s1 we will try to find out our answer.
And in every window, we will count the frequency of every character. If frequency of every character is same as the frequecy of every character in s1, we are able to say that yess there exist a permutation.
Now Question arises how we will implement that ?-

On hearing the term frequency, we will remember our one and only superhero i.e unordered map.
And on hearing the term window, we will easily know that we are going use sliding window algorithm.
So, first we make an unordered map and in unordered map we will store the frequency of string s1.
The size of the map tells us that how many distinct (different) letters present in string s1, so we will have to take a count that also, so saycount = mp.size().
Now, the size of window will be as same as the length of string s1 na, so say k = s1.length().
We start moving in our string s2, and for every charcter of s2, we will check whether this is present in our map or not. If present in map then decrease the frequency of that particular letter.
Also if at any point the frequency of any charcter becomes zero, then it will denote as that the frequency of one of the distinct letter becomes zero, so we have to decreae the count also at that point.
When we hit the window size (j - i + 1) we will check whether our count is zero or not, if count is zero, from there return true, saying that yes we find an permutation of string s1.
And if not, then we have to slide the window na, but before sliding we have to add the frequency of the letter in our map, and also check whether the frequency of this particular letter becomes 1. If yes then also increment our count.
At last, if travelling in every window of s2, we are unable to find our answer, then we will return false saying that, we are not able to find any such permutation of s1 that exist in s2.
See commented code, for more clarification.
Time Complexity --> O(n) // where n is the length of string s2
Space Complexity --> O(n) // we are using unordered map from our side
It paases [ 106 / 106 ] in built test cases
Code (C++)

class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        int n1 = s1.length(); // extracting length of string s1
        int n2 = s2.length(); // extracting length of string s2
        
        if(n1 > n2) // if length of s1 is greater than length of s2 
            return false; // then simply return false, because it is impossible
        
        // unordered map for storing frequency of every character of s1
        unordered_map<char,int> mp; 
        
        // traverse from the string s1
        for(int i = 0; i < s1.length(); i++)
        {
            mp[s1[i]]++; // store frequency of every character
        }
        
        int i = 0, j = 0; // variable for sliding window
        
        // it tells us the number of distinct letters present in s1
        int count = mp.size(); 
        
        
        int k = s1.length(); // size of the string s1 is our window size
        
        // start moving in string s2
        while(j < n2)
        {
            if(mp.find(s2[j]) != mp.end()) // if this particular charcter of s2 is present in map
            {
                mp[s2[j]]--; // then decrease its frequency in map
                
                // if any point the frequency of any character becomes zero, 
                // then we will decrease count 
                // saying that frequency of one distinct letter of s1 becomes zero
                if(mp[s2[j]] == 0) 
                {
                    count--;
                }
            }
            
            if(j - i + 1 < k) // if window size is less than required window,
            {
                j++;
            }
            else if(j - i + 1 == k) // if window size is hits the required window,
            {
                if(count == 0) // then we check whether count is zero or not
                {
                //if yes we will return true saying that we are able to find out
                // one possible permutation of s1 in string s2
                    return true;
                }
                
                // if not, we will add the frequency of letter when we slide it
                if(mp.find(s2[i]) != mp.end())
                {
                    mp[s2[i]]++;
                    
                    // if it's frequency becomes 1, then increment count also
                    // saying that, one more distinct letter is added
                    if(mp[s2[i]] == 1)
                    {
                        count++;
                    }
                }
                
                // slide the window
                i++;
                j++;
            }
        }
        
        // after checking all the windows in s2, if we still uable to find any permuation, we will return false saying that no permutation of s1 exist in s2
        return false;
    }
};