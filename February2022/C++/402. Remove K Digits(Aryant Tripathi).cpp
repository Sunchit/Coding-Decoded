Brief note about Question-

We have to return the smallest possible integer after removing k digits from given string.
Let's take an example not given in question -
Suppose string of numbers given to us as str = "1972345" and k = 2

So, the answer should be "12345" as we remove two digits i.e 9 and 7
Solution - I (using Stack, Accepted)-

Okay, First let's go through some of the examples, to understand better what we are going to do.
Suppose strng given to us is str = "291" and k = 1
                          9
                         / \
					    /   \
					   /     \
					  /       \
					2          \
		                        1			
So, The number should looks like this, 
Now see, we are able to remove only one digit. By seeing above what should be the number we 
have to remove, we say obviously it's '9' because after removing this number we are 
able to get the smallest possible integer and i.e 21.
So, we got our intiutaion from here that, to make the smallest number we have to make the numbers in ascending order as much as it is possible.
And to make a number in ascending order we have to remove the largest numbers present in the string.
Now, take anthor example-
Suppose strng given to us is str = "27291" and k = 1

                               9
                              / \
                             /   \
                7           /     \
               / \         /       \
              /   \       /         \
             /     \     /           \ 
            /       \   /             \
		   /         \ /               \
          2           2                 \
		                                 1
So, the number should looks like this.
Now, as we above see, then we say that we will remove 9 and we got our answer.
Let's see, 
If we remove 9 then we got our answer is "2721".
But if we remove '7' we got our answer is "2291"

Therefore, we can see that, it is better to remove '7' than '9'.
So, why this happen?
We will say that, since weight of 7 in string is more than that of 9 that's why it is better to remove7.
Okay, what do we mean by weight?
The weight of a number is the digit place in string, that means in the above example if we will see the weight of 7 is said to 7 * 1000 = 7000 and weight of 9 is 9 * 10 = 90.
Finally, we conclude that, we start traversing string from left to right and whenever we will see a peak, we remove it.
But, their is a special case which may have arrived that, What if string contains all numbers already in ascending order? Then how we will remove elements?
Take anthor example.
Suppose strng given to us is str = "1234" and k = 1
              4        
			 /		 
			/			 
		   3			 
		  /				 
		 /			 
		2
	   /
	  /
	 1 
In this case we never see a peak, that means, we not remove any number.
So, How we will remove element in this case?
Since we already know, all the elements arranged in ascending order here, so we simply start removing elements from the back.
Here, we will remove 4 and we got our answer as '123'.
Implementation part-

If we carefully observe that, then we will find out, everytime we have to remove our previous occuring peaks, so which data structure we will use to remove those previous peaks?
Answer is stack.
Let's take ansthor example to understand it in a better way.
we start traversing string from left to right. (Already discussed it above)

Suppose strng given to us is str = "14301620" and k = 4.
say our stack is as s: [       ] // currently empty
 
str = " 1 4 3 0 1 6 2 0"        and s: [  ]   
        ↑
		push '1' to stack, s become s: [1]
		
str = " 1 4 3 0 1 6 2 0"        and s: [1]            
          ↑
		  since '4' (current element) is greater than '1' (i.e s.top()), that means 
		  their is no dip, so we will simply push this into our stack,
		  now s becomes, s: [1, 4]

str = " 1 4 3 0 1 6 2 0"       and s: [1, 4]       
            ↑
			now, '3' (current element) is less than '4' (i.e s.top()), that means
			we have found our first peak element & we have k value > 0,
			so we will remove it from our stack.
			
			We will keep popping element until our s.top() is greater than current element.
			therefore, k becomes 3 (as we delete our first character)
			and push current element to our stack.
			now s becomes s: [1, 3]
			
str = " 1 4 3 0 1 6 2 0"        and s: [1, 3]   
              ↑
			  now, '0' (current element) is less than '3' (i.e s.top()), that means
			  we have to again remove elements from the stack until 
			  our s.top() is greater than current element.
			  so, pop '3' and also pop '1'
			  and also our k decreases by 2 times, because we removing two elements.
			  previouly our k is 3,
			  therefore now it becomes k = 3 - 1 - 1 = 1 and s becomes s: [  ]
			  
			  see, this is also an intersting case, 
			  our current element is '0' and our stack is empty.
			  so, we will not push '0' into our stack because
			  it will lead to us leading zero in our final answer.
			  so, we neglect zero and move ahead.
			 
str = " 1 4 3 0 1 6 2 0"        and s: [  ]   
                ↑
				now, nothing to comapre, push '1' to stack.
				s becomes s: [1]
				
str = " 1 4 3 0 1 6 2 0"        and s: [1]   
                  ↑
				   now, '6' (current element) is greater than '1' (s.top())
				   so push '6' into stack, s becomes s: [1 6]
				   
str = " 1 4 3 0 1 6 2 0"        and s: [1, 6]   
                    ↑
					now, '2' (current element) is less than '6' (s.top())
					so, their is a peak and we have to remove elements from stack until
					s.top() is greater than current element.
					
					so, pop '6' from stack, s becomes s: [1]
					and also our k get decreases by 1, 
					so k = k - 1, previously our k is 1,
					therefore now our k becomes 0.
					
					so, when our k becomes zero, that means from now
					we are unable to delete any element,
					so, from now, without seeing anything 
					push all remaining elements of string into our stack.
					also we have to push '2' into our stack so becomes s: [1, 2]
					
str = " 1 4 3 0 1 6 2 0"        and s: [1, 2]   
                      ↑
		               we do not have to see anything, so push zero into our stack
					   s becomes s: [1, 2, 0]
					   
Now, the remaing elements which remains in our stack should be our answer,
therefore our answer should be "120"
Time Complexity --> O(n) // where n is the length of the string
Space Complexity --> O(n) // we are using stack from our side

It paases [ 40 /  40] in built test cases
Code (C++)

class Solution {
public:
    string removeKdigits(string str, int k) {
        int n = str.length(); // extracting length of the string
        
        stack<char> s; // make stack
        
        for(char c: str) // start traversing from string
        {
            // if top of the stack is greater than our current element, then pop
            while(s.empty() == false && k > 0 && s.top() > c)
            {
                s.pop();
                k = k - 1; // also decrease k
            }
            
            if(s.empty() == true && c == '0') // ignoring any leading zero
            {
                continue;
            }
            else
            {
                s.push(c); // else push element to stack
            }
        }
        
        // case if string given to us is in ascending order, as we dicussesd for the example
        // str = "1234" and k = 1
        while(s.empty() == false && k != 0)
        {
            s.pop();
            k--;
        }
        
        // if stack becomes empty, simply return "0"
        // take example as, str = "1234" and k = 4
        if(s.empty() == true) 
        {
            return "0";
        }
        
        // if we don't want to make anthor sting ans, then we may also store it in
        // given str string, i alsoo do that, see below
        string ans = "";
        
        while(s.empty() == false)
        {
            ans += s.top();
            
            /* if we don't want to make answer string,
            we can also do it in this way
            
             str[n - 1] = s.top();  
             n = n -1;  */
            
            s.pop();
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
        
        // if we don't want to use answer string
        //return str.substr(n);
        
    }
};
