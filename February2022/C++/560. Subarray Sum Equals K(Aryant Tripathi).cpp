Brief note about Question-

We have to return the total number of continuous subarrays whose sum equals to k.
Let's take an example not given in the question by taking negative numbers
Suppose our arr is arr[]: [-1, -1, 1]  && k = 0

So, the answer should be '1' as their is only one subarray whose sum is 0 i.e (-1 + 1)
Solution - I (Brute force, TLE)-

Since we are very obedient person and don't want to do anything extra from our side.
So, we will try to generate the sum of each subarray and if matches withk , then increment our answer.
Like, this is the most basic thing we can do.
Time Complexity --> O(n ^ 2) // where n is the size of the array
Space Complexity --> O(1) // we are not using anything extra from our side
It paases [ 85 / 89 ] in built test cases
Code (C++)

class Solution {
public:
    int subarraySum(vector<int>& arr, int k) {
        int n = arr.size(); // taking the size of the array
        
        int ans = 0; // ans variable to store our count
        
        for(int i = 0; i < n; i++) // traverse from the array
        {
            int sum = arr[i]; // provide sum with arr[i]
            
            if(sum == k) // if element itself equal to k, then also increment count
                ans++;
            
            for(int j = i + 1; j < n; j++) // now moving forward,
            {
                sum += arr[j]; // add elements with sum
                
                if(sum == k) // if at any point they become equal to k
                    ans++; // increment answer
            }
            
        }
        
        return ans; // and at last, return answer
    }
};
Solution - II (Concept of prefix sum, Accepted)-

So, can we optimise our code.
Answer isyes, .
Instead of traversing the whole array every time, can we able to store prefix sum already and then check with that.
So, with the help of an unordered map, we will store sum.
Some explanation regarding code part-

So, suppose we have an array as arr[]: [1,2,3,4,5] and k = 9

so, our answer will be '2' i.e (2 + 3 + 4 and 4 + 5)
so if we store our prefix sum array then it should looks like:
index :   0, 1, 2, 3,  4
  arr[]: [1, 2, 3, 4,  5]
prefix[]:[1, 3, 6, 10, 15]
          ↑         ↑

How, we will find our subarray (2 + 3 + 4) using prefix sum, see-

1) if we see our prefix sum at index 3 then it is 10 and also prefix sum at index 0 is 1
so, we can say that from index 0 to 3 our prefix sum increases from 1 to 10, right,

2) So on putting a question, HOW MUCH ? means how much our sum increase from index 0 to index 3
then, we simply say, we find the difference between these two sums i.e (10 - 1) is the sum that increases from index 0 to 3.

3) If (10 - 1) sum increases from index 0 to 3, then we can say that, ok, this difference, should be the sum of elements greater than index 0, and upto index 3, i.e from index 1 to index 3,right.

4) Now, if we will see then we find out (10 - 1) is nothing but our 'k' that is 9.

5) So, we find out, that a subarray may also exist if this particular condition satisified, i.e
    (prefix[i] - k) should exist in our map, 
	
	How? see,
	
	If prefix[i] - prefix[j] = k where i > j (i, j any index, in our case they are i = 3, j = 0)
	prefix[i] - k = prefix[j] na, (simple maths)
	
	i.e if we are able to find (prefix[i] - k) is exist in our map, i.e prefix[j]
	so, we can say that from index j + 1 to i, the sum of the elements is k, right na,
	hence it proves that their exist an subarray from index j + 1 to i whose sum is k.
	
Now, for subarray (4 + 5) we again find this valid see -

index :   0, 1, 2, 3,  4
  arr[]: [1, 2, 3, 4,  5]
prefix[]:[1, 3, 6, 10, 15]
                ↑       ↑
				
1) if we see our prefix sum at index 4 then it is 15 and also prefix sum at index 2 is 6
so, we can say that from index 2 to 4 our prefix sum increases from 6 to 15, right,

2) So on putting a question, HOW MUCH ? means how much our sum increase from index 2 to index 4
then, we simply say, we find the difference between these two sums i.e (15 - 6) is the sum that increases from index 2 to 4.

3) If (15 - 6) sum increases from index 2 to 4, then we can say that, ok, this difference, should be the sum of elements greater than index 2, and upto index 4, i.e from index 3 to index 4,right.

4) Now, if we will see then we find out (15 - 6) is nothing but our 'k' that is 9.

5) So, we find out, that a subarray may also exist if this particular condition satisified, i.e
    (prefix[i] - k) should exist in our map, right na,
	
	How? see,
	
	If prefix[i] - prefix[j] = k where i > j (i, j any index, in our case they are i = 4, j = 2)
	prefix[i] - k = prefix[j] na, (simple maths)
	
	i.e if we are able to find (prefix[i] - k) is exist in our map, i.e prefix[j]
	so, we can say that from index j + 1 to i, the sum of the elements is k, right na,
	hence it proves that their exist an subarray from index j + 1 to i whose sum is k.
	
	I hope u got the reason now, why we will do (prefix[i] - k) in our code.
Time Complexity --> O(n) // where n is the size of the array
Space Complexity --> O(n) // we are using unordered map from our side
It paases [ 89 / 89 ] in built test cases
Code (C++)

class Solution {
public:
    int subarraySum(vector<int>& arr, int k) {
        int n = arr.size(); // take the size of the array
        
        int prefix[n]; // make a prefix array to store prefix sum
        
        prefix[0] = arr[0]; // for element at index at zero, it is same
        
        // making our prefix array
        for(int i = 1; i < n; i++)
        {
            prefix[i] = arr[i] + prefix[i - 1];
        }
        
        unordered_map<int,int> mp; // declare an unordered map
        
        int ans = 0; // to store the number of our subarrays having sum as 'k'
        
        for(int i = 0; i < n; i++) // traverse from the prefix array
        {
            if(prefix[i] == k) // if it already becomes equal to k, then increment ans
                ans++;
            
            // now, as we discussed find whether (prefix[i] - k) present in map or not
            if(mp.find(prefix[i] - k) != mp.end())
            {
                ans += mp[prefix[i] - k]; // if yes, then add it our answer
            }
            
            mp[prefix[i]]++; // put prefix sum into our map
        }
        
        return ans; // and at last, return our answer
    }
};