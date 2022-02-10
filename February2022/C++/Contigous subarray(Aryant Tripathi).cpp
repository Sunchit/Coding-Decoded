Brief note about Question-

We have to return the maximum length of a contiguous subarray with an equal number of 0 and 1,

Take an example :
index-->         0, 1, 2, 3, 4, 5, 6                       
suppose  arr[]: [1, 1, 1, 0, 0, 1, 1] 

so, the answer should be 4 (take subarray from index 1 to 4 (1100) or subarray from index 3 to 6 (0011))
Since, we have to just return the length of the contiguous subarray, so we don't care about subarrays.
Solution - I (Most basic approach, TLE)

Okay, so the most basic approach we can think of is, we are obedient person, and not to do anything extra from ourself,
We will simply do what the question wants us to do, so we start counting the number of zeroes and number of ones.
If at any position the count of zeroes and ones becomes equal we will simply check it with our previous length of contiguous subarray.
If the length of new window is greater than our previous length of subarray,
We update it with the current window size.
And last we return our length of the max_subarray.
Time Complexity --> O(n ^ 2) &
Space Complexity --> O(1)
It paases [ 31 / 564 ] in built test cases
Code (C++)

class Solution {
public:
    int findMaxLength(vector<int>& arr) {
        int zeroes = 0, ones = 0; // variables to store count of zeroes and ones
        int max_subarray = 0; // length of the subarray to be return
        
        for(int i = 0; i < arr.size(); i++) // traversing from the whole array
        {
            zeroes = 0, ones = 0;
            for(int j = i; j < arr.size(); j++)
            {
                if(arr[j] == 0) // counting zero
                {
                    zeroes++;
                }
                else if(arr[j] == 1) // counting one
                {
                    ones++;
                }
                
                if(zeroes == ones) // if count of zeroes and ones become equal
                {
                    max_subarray = max(max_subarray, j - i + 1); // update the window size
                }    
            }
        }
        
        return max_subarray; // return final length of contiguous subarray 
    }
};
One thing is to observe here is, when the count of number of zeroes and one is equal then the window size is (j - i + 1), how this is possible?
I am taking an example, u will understand, so see
index-->         0, 1, 2, 3, 4, 5, 6                       
suppose  arr[]: [1, 1, 1, 0, 0, 1, 1] 
suppose i & j are:  i        j      are here

then value of (j - i + 1) is (4 - 1 + 1 ) --> 4
and manually count elements between index 1 and index 4 is (1,1,0,0) i.e 4
so (j - i + 1) is the window size.
Take some more example by yourself you will understand better. 
Solution - II (Use of unordered map, Accepted)

Now, we want to become a good programmer and anyhow we want accepted on our soloution.
One thing which is most important to observe here is, we have given a binary array, so all the elements of given aray is either 1 or 0.
We will assume 0 as -1 and 1 as +1, and then we start taking sum of the array, so whenever we got our sum as zero then that means that number of zeroes is equal to number of ones and hence we compare that window with our previous max_subarray and update it.
But the question arises is this enough to calculate our max subarray?
Let's take an example:
Take an example :
We assume '0' as '-1' and '1' as '+1'
so sum proceeds in the manner like this,
intially sum = 0;

index-->         0, 1, 2, 3, 4, 5, 6                       
suppose  arr[]: [1, 1, 1, 0, 0, 1, 1]
           sum: {1, 2, 3, 2, 1, 2, 3}

Here, We can see simply see that we never got our sum as Zero,
So are we assume that their is no subarray present here when number of zeroes is equal to number of ones?
Naah, This is not right, we observe that subarray from index 1 to 4 (1100) and also subarray from index 3 to 6 (0011) have equal number of zeroes and ones,
Therefore we can conclude that, still we are missing something, we need more of it.
So, How we will proceed, since whole problem is now link with our sum (as it not become zero at any instant, we will start observing our sum.
From above e.g we got our sum as sum: {1, 2, 3, 2, 1, 2, 3} . We can see that first sum start increases and then decreses and then also increases but never become zero.
If it becomes zero at any instant then we are able to say that yes, we got a candidate for our subarray, but it not happen.
Now, just calculate the sum between index 1 to 4 and between index 3 to 6-
index-->           0, 1, 2, 3, 4, 5, 6                       
suppose    arr[]: [1, 1, 1, 0, 0, 1, 1]
             sum: {1, 2, 3, 2, 1, 2, 3}
	
sum b/w index 1 & 4: {1, 2, 1, 0}
     sum b/w index 3 & 6 { -1,-2,-1,0}
So, if we observe sum[0] = 1 and sum[4] = 1 this means after travelling some distance we return back to our same sum, meaing that in b/w these two indices our sum is zero na, that's why our sum neither increases nor decreases b/w these two points,so this is a possible candidate for our max_subarray and for other indices also you can check this by yourself.
Now, main point is this how we remember our last sum that yess it is occured? Map, we will use an unordered map for this,
But how unordered map will help us?
We will use key as sum and value as index saying that this particular sum occured at this index.
So on cocluding what we will do?
First, we treat 0 as -1 and 1 as +1 and calulate our sum.
We use an unordered map for storing sum as key and value as the index on which sum is found.
If the sum is already present in the map then length of the window simply becomes the difference of current index and value of map.
We then compare the lengths and update our max_subarray
And at last , we return our max_subarray.
One More thing which remain left is,
What about sum as zero now ?
Just see this-

index-->           0, 1, 2, 3, 4, 5, 6, 7, 8, 9                       
suppose    arr[]: [1, 1, 1, 1, 0, 0, 0, 0, 1, 1]
             sum: {1, 2, 3, 4, 3, 2, 1, 0, 1, 2}
Here, sum[7] == 0 and we can say that, If at any point our some becomes zero, then the length of the subarray will start from begining to that current index , as here the length of the subarray becomes 7 - 0 + 1 = 8.

Time Complexity --> O(n) &
Space Complexity --> O(n) (Since we are using an unordered map for storing sum)
It paases [ 564 / 564 ] in built test cases
Code (C++)

class Solution {
public:
    int findMaxLength(vector<int>& arr) {
        int sum = 0; // variable for sum
        int max_subarray = 0; // our max_subarray length
        
        unordered_map<int,int> mp; // map for storing sum
        
        for(int i = 0; i < arr.size(); i++) // traversing the array
        {
            if(arr[i] == 1) // if element is 1 then we treat it as +1
            {
                sum = sum + 1;
            }
            else if(arr[i] == 0) // if element is 0 then we treat it as -1
            {
                sum = sum - 1;
            }
            
            if(sum == 0) // if sum becomes zero, then we take length from start
            {                 // j  - i + 1
                if(max_subarray < i - 0 + 1)
                {
                    max_subarray = i + 1;
                }
            }
            else if(mp.find(sum) != mp.end()) // if sum already present in the map
            {
                int len = i - mp[sum]; // taking length
                
                if(max_subarray < len) // comparing
                {
                    max_subarray = len; // updating
                }
            }
            else
            {
                mp[sum] = i; // store this new sum in our unordered map
            }
        }
        
        return max_subarray; // return max subarray
    
    }
};