@Jiganesh

# Question : https://leetcode.com/problems/binary-tree-right-side-view/

class Solution(object):
    
    # Naive Solution 
    # ACCEPTED
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root: return []
        
        q = [root]
        result= []
        while q :
            result.append(q[-1].val)
            q = [child for p in q for child in [p.left, p.right] if child]
            
        return result
    
    # TC : O(N)
    # SC : O(H)
    
    # Runtime: 47 ms, faster than 5.05% of Python online submissions for Binary Tree Right Side View.
    # Memory Usage: 13.6 MB, less than 25.43% of Python online submissions for Binary Tree Right Side View.
    
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        
        def helper(arr, root, level):
            if root:
                if level >= len(arr):
                    arr.append(root.val)
                    
                helper(arr, root.right, level+1)
                helper(arr, root.left, level+1)
                
            return arr
        
        array , level =[], 0
        return helper(array, root, level)