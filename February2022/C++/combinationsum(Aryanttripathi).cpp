Brief note about Question-

In simple words, we have to return all possible combination of array whose sum is equal to a particular target.
Let's take an example not given in question -
Suppose our array is given to us as arr[]: [2, 3] and target as 6

Then, all possible combinations of array whose sum is equal to 6 is-
[[2,2,2] , [3,3]]

General discussion on how we devlop approach-

This was a problem where we have to explore all possibility, make each combination and if sum of a combination becomes equal to target sum then we have to store that possible combination in our answer array.

One more thing we have to notice here is that, for a particular element we have unlimited choice i.e we can choose a element as many times as we want.

But their is some restiction also on choosing a number.

See for every number in making our target sum, we have two possibility i.e

Whether to include that element in making our target sum.
Whether not to include that element in making our target sum.
We will try and explore each possible combination and if at a point we got our sum as zero then we will say yeah!!, we find a possible combination and include that combination in our answer.

Suppose if at any point our target sum becomes less than zero, then we will return from that point and will not explore further possibility by saying that, ok our target sum becomes negative that means from now no any combination is possible because we have given a non - negative array.

See below tree diagram for more clarity.

How Tree diagram will work-

We will make a op array, that contains all the possible combinations sum of the array.

We will start from the index 0 and as we already discussed that for each and every element we have two possibility whether to include this element in making our answer or not, so we will explore all possibilities.

op aray represents which elements this array contains now in making combination sum.

Target represents the left combination sum that we have to make. Intially it is same as the original target that we have to make.

The red cursor below the array, points that on which index we are currently standing.

If at any point our target becomes zero, then we will include that combination in our answer array saying that yes, this is an possible combination and return from there.

If at any point our target becomes less than zero, then we return from there saying that we are never able to make our cbination sum by this combination.

If at any point we cross the size of the array then we will return from there saying that no more element is left to choose.

As we dicussed for every element we have two choices whether to include in our answer or not include in our answer.

So, if we do not a include a element in our answer then without decreasing target sum, we will move to next index. Why we do not decrese sum? because we will choose not to include in this element in our combination, hence it does not contribute in making our sum.

But, if we choose a particular element to include in our answer, then we will decrease the target sum but we will not move to next index. Why we will not move to next index? because for a specific element we have unlimited number of choice, so it may be possible that specific element again contribute in making our sum.

If Image is not cleary visible to you, then for that I have uploaded it on my drive.

You may visit this link to see Image in good quality.

LINK :- TREE DIAGRAM

image

Solution - I (using backtracking, Accepted)-

class Solution {
public:
    vector<vector<int>> ans; // 2 D vector to store our answer
    void solve(int i, vector<int>& arr, vector<int>& temp, int target)
    {
        // if our target becomes zero at any point, then yess!! we wil find a possible combination
        if(target == 0) 
        {
            ans.push_back(temp); // include that combination in our answer
            return; // and then return, we are now not gonna explore more possiblity
        }
        
        // if at any point target becomes less than zero, then simply return, saying that no it is notpossible to our target combination sum
        if(target < 0)
            return;
        
        // if index crosses the last index, we will return saying that no more element is left to choosee
        if(i == arr.size())
            return;
        
        // As we dicussed for every element we have two choices whether to include in our answer or not include in our answer. 
		//so now, we are doing that
        
        // we are not taking the ith element,
        // so without decreasing sum we will move to next index because it will not contribute in making our sum
        solve(i + 1, arr, temp, target);
        
        // we are taking the ith element and not moving onto the next element because it may be possible that this element again contribute in making our sum.
        // but we decrease our target sum as we are consediring that this will help us in making our target sum
        
        temp.push_back(arr[i]); // including ith element
        solve(i, arr, temp, target - arr[i]); // decreasing sum,and call again function
        temp.pop_back(); // backtrack
        
    }
    vector<vector<int>> combinationSum(vector<int>& arr, int target) {
        ans.clear(); // clear global array, make to sure that no garbage value is present in it
        
        vector<int> temp; // temporary vector that tries all possible combination
        
        solve(0, arr, temp, target); // calling function, and see we start from index zero
        
        return ans; // finally return the answer array
    }
};
Solution - II (using Recursion, Accepted)-

class Solution {
public:
    // for the sake of convience, not to include again and again in my function call, I declare target here
    int target;
    
    vector<vector<int>> ans; // 2-D vector to store our answer
    
    void solve(vector<int>& arr, int i, int sum, vector<int> op)
    {
        // if i crosses the array size, we will return saying that no more possibilty is left to choose
        
        if(i >= arr.size()) 
        {
            return;
        }
        
        // if value at ith index + sum becomes equal to target, then we will store it in our answer array, saying that yes it is a possible combination
        if(arr[i] + sum == target)
        {
            op.push_back(arr[i]);
            ans.push_back(op);
            return;
        }
        
        // if value at ith index + sum is less than target, then we have two choices i.e whether to include this value in our possible combiation array or not include that,
        if(arr[i] + sum < target)
        {
            // we make two output vector, one for calling function at same index and anthor for calling function frm next index. Because for every element we have unlimited choices, that it will contribute in making our sum any number of times.
            vector<int> op1 = op;
            vector<int> op2 = op;
            
            op2.push_back(arr[i]);
            solve(arr, i, sum + arr[i], op2);
            solve(arr, i + 1, sum, op1);
        }
        else
        {
            solve(arr, i + 1, sum, op); // call for the next index
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& arr, int required_target) {
        ans.clear(); //clear global array, make to sure that no garbage value is present in it
        
        target = required_target; // give target what he wants 
        vector<int> op; // op array to try all possible combination
        sort(arr.begin(),arr.end()); // sort the array in ascending order
        solve(arr, 0, 0, op); // call function
        
        return ans; // return the final answer array
    }
};