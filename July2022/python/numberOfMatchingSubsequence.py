@Jiganesh
# https://leetcode.com/problems/number-of-matching-subsequences/

from itertools import Counter
from typing import List
from collections import defaultdict 

class Solution:
    
    # BruteForce Accepted (Runtime : 6543 ms)
    
    # TC : O(N*S)
    # SC : O(N) 
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        
        def helper(parent , child):
            
            parent_pointer = 0
            child_pointer = 0
            
            while child_pointer<len(child) and parent_pointer< len(parent):
                if parent[parent_pointer]==child[child_pointer]:
                    child_pointer+=1
                parent_pointer+=1
                
            return child_pointer == len(child)
        
        words_counter = Counter(words)
        result = 0
        for word in words_counter:
            if helper(s, word):
                result+=words_counter[word]
                
        return result 
    
    
    # Runtime: 563 ms, faster than 75.62% of Python3 online submissions for Number of Matching Subsequences.
    # Memory Usage: 15.7 MB, less than 51.10% of Python3 online submissions for Number of Matching Subsequences.
    # TC : O(S*N*N) 
    # SC : O(N)   
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        
        dictionary = defaultdict(list)
        
        for word in words:
            dictionary[word[0]].append(word)
            
        result = 0
        for character in s:
            
            for word in tuple(dictionary[character]):
                if word[0]==character:
                    dictionary[character].remove(word) # remove the word from the list this case handled in next solution 
                    if word[1:]=="" : 
                        result+=1
                    else:
                        dictionary[word[1]].append(word[1:])
        return result
    
    # Optimized
    # TC : O(S*N) 
    # SC : O(N)   
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        
        
        dictionary = defaultdict(list)
        
        for word in words:
            dictionary[word[0]].append(word)
            
        result = 0
        for character in s:
            
            words_starting_with_character = dictionary[character]
            dictionary[character] = []
            
            for word in words_starting_with_character:
                if len(word)==1:
                    result+=1
                else:
                    dictionary[word[1]].append(word[1:])

        return result
