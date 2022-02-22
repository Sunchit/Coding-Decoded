Brief note about Question-

We have to returnk after placing the final result in the first k slots of array.

In simple words, we are given a array in non- decreasing order and any element may present any number of times.
We have to rearrange array such that each unique element appears at most twice.
Let's take an example other than the given in question-
suppose we have -------------->    arr[]: [1,1,1,1,2,2,2,2,3,3,4,4,6,6,6,6,6,6,7,7]
so, we have to rearrange like this arr[]: [1,1,2,2,3,3,4,4,6,6,7,7, _ _ _ _ _ _ _ _]
and for the rest of the elements we don't have to care about it.
Solution - I ( Accepted)-

Main point is to observe here is that array is sorted in non-decreasing order.
That was like pretty good advantage for us.
Now, simply see what we have to do ?
We have to rearrange array such that each unique element appears at most twice.
We have to take care like a particular element as long as it is appeared two times we don't do anything, but if it's count becomes greater than by 2 then we have to replace it by the next unique element.
So, the basic thing we have to check is either the size of the array is greater than 2 or not. If the size of the array is less than 3, then we don't have to do any changes and simply return the size of the array.
Now, If size is greater than 2 then we start traversing from index 2and see the value present at index - 2 is whether the value at index - 2 is equal or not.
If It is not equal then we place the current index value to it.
It was like we travel from the array and if it does not violate our condition i.e unique element appears at most twice, we will leave it but if this violate our condition we will change it from the next unique element.
So, How I will code it ?

First, we check size of the given array, if it is less than 2 then at that point we return the same array without any modification.
If size is greater than 2, then we declare ourk = 2, because as long as only two elements are their we don't have any problem from the array.
Now, we start traversing the array from index = 2 and also our k is 2 intially.
Here, we check whether element at index = 2is equal to the k - 2 or not, if it is equal then we know that ok, this element is the repeated number and we have to replace it.
Since, we are already traversing our array so when our index value is not equal to k - 2, then we are able to say that yess!, we got an unique number which is replacable, so we will replace it with the value present at index k.
And lastly,increment k, in the search of next value.
Like this we traverse and replace our whole array.
See dry run on the first example -

Suppose array is like arr[]:  [1,1,1,2,2,3]
* First thing we have to check if it's size is greater than 2 or not, 
Okay, size of the array, let say it is as n = arr.size() = 6
so, size of array is greater than 2 (i.e n > 2 i.e 6 > 2), we are good to go and proceed further.
Now,  
our array is arr[]: [1,1,1,2,2,3]
so, we declare our k as 2, because upto 2 elements we don't have any problem and we are able to proceed further.
index -->                    0, 1, 2, 3, 4, 5
therefore, k = 2 and arr[]: [1, 1, 1, 2, 2, 3]
so, we traversing from i = 2,      ↑
we see arr[i] == arr[k - 2], 
       arr[2] == arr[2 - 2]
	   arr[2] == arr[0]
	        1 == 1
we know this is the repeated number and we have to replace it,
now, our i increment, goes to 3, i.e i = 3
index -->                    0, 1, 2, 3, 4, 5
therefore, k = 2 and arr[]: [1, 1, 1, 2, 2, 3]
now our  i = 3,                       ↑
we see, arr[i] != arr[k - 2]
        arr[3] != arr[2 - 2]
	    arr[3] != arr[0]
		     2 != 1
we say that yes it is our next unique element, and hence we replace arr[k] with arr[i]
and we replace it, we increment our k, in search of next unique elements.

I guess, at this point, u got the approach, but still u have doubt u may comment that, we will solve that together, 
Now, moving on the code portion and time and space complexity
Time Complexity --> O(n) // as we are traversing array single time
Space Complexity --> O(1) // we don't use anything extra from our side
It paases [ 164 / 164] in built test cases
Code (C++)

class Solution {
public:
        // see, I don't do anything extra, I simply code what i tell, so If u read above all the things, please try to write this code by your own, & still
        // if u face any problem then proceed to see it.
    
    int removeDuplicates(vector<int>& arr) {
        int n = arr.size(); // extracting the size of the array
        
        if(n < 3) // if size is less than 3
            return n; // simply return n without any modification
        
        // we declare our k as 2 because upto two elements we don't have any problem
        int k = 2; 
        
        for(int i = 2; i < n; i++) // start traversing the array
        {
            if(arr[i] != arr[k - 2]) // if not equal we got our next unique element
            {
                arr[k] = arr[i]; // replace it
                k++; // increment k
            }
        }
        
        return k; // and at last, retun k
        
    }
};