Brief note about Question-

We have to return all possible subsets (the power set).
Lets take an example which is not given in the question-
suppose array is given arr[]: [7,4,5]

so, the answer should be 
[[],[7],[4],[4,7],[5],[5,7],[4,5],[4,5,7]]
Solution - I (Backtracking, Accepted)-

class Solution {
public:
    // it is use to store answer
    vector<vector<int>> ans;
    
    // solve function for generating answer
    void solve(int i, vector<int>&arr, vector<int>&temp)
    {
        if(i == arr.size()) // if index reaches the size of the array 
        {
            //if we find out a possibility, push it into the answer array
            ans.push_back(temp);
            return;
        }
        
        // taking ith element
        temp.push_back(arr[i]);
        
        // call for the next index
        solve(i + 1, arr, temp);
        
        // not taking ith ele,so first pop that already pushed ele, and then call for next index and generating the next possibility
        temp.pop_back();
        
        // calling for next index
        solve(i + 1, arr, temp);
        
    }
    vector<vector<int>> subsets(vector<int>& arr) {
        ans.clear(); // clear global array
        
        vector<int> temp; // temporary array for generating answer
        solve(0, arr, temp); // generating all possibility
        
        return ans;
    }
};
Solution - II (Accepted)-

class Solution {
public:
    vector<vector<int>> ans; // to store answer
    
    void solve(vector<int> &arr, int i, vector<int> temp)
    {
        if(i == arr.size()) // if we find out one possibility
        {
            //push into the final answer that possibility
            ans.push_back(temp); 
            return;
        }
        
        solve(arr, i + 1, temp); // finding possibility for next index
        
        temp.push_back(arr[i]); // push into the array
        
        solve(arr, i + 1, temp); //again finding out the next possibility
        
    }
    vector<vector<int>> subsets(vector<int>& arr) {
         vector<int> temp; // vector to store temporary answer
        
        solve(arr, 0, temp); // function that will generate our final answer
        
        return ans; // return the final answer
    }
};