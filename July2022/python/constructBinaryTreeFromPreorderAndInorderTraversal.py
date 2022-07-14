@Jiganesh

# https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        
class Solution(object):
    
    # Runtime: 115 ms, faster than 75.80% of Python online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    # Memory Usage: 19 MB, less than 73.98% of Python online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    
    # Efficient and Optimized
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        index_lookup =  {val:ind for ind, val in enumerate (inorder)}
        def helper(instart, inend , prestart, preend):
            
            if prestart > preend or instart>inend : return None
            
            root = TreeNode(preorder[prestart])
            
            root_in_index = index_lookup[preorder[prestart]]

            element_to_left = root_in_index-instart
            
            root.left = helper(instart, root_in_index-1 ,prestart+1, prestart+element_to_left+1)
            root.right = helper(root_in_index+1, inend , prestart+element_to_left+1, preend)
            
            return root
    
        return helper(0, len(inorder)-1, 0, len(preorder)-1,)
    
    # Extra Space but Elegant Code
    
    # Runtime: 129 ms, faster than 72.91% of Python online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
    # Memory Usage: 52.3 MB, less than 55.77% of Python online submissions for Construct Binary Tree from Preorder and Inorder Traversal.    
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        

        def helper (inorder):
            root =None
            if inorder :
                
                root_val = preorder.pop(0)
                root_ind = inorder.index(root_val)
                
                root = TreeNode(root_val)
                
                root.left = helper(inorder[:root_ind])
                root.right = helper(inorder[root_ind+1:])
                
            return root
        
        return helper(inorder)
    
    # More Elegant 
    def buildTree(self, preorder, inorder):
        if inorder:
            INDEX = inorder.index(preorder.pop(0))
            root = TreeNode(inorder[INDEX])
            root.left = self.buildTree(preorder, inorder[:INDEX])
            root.right = self.buildTree(preorder, inorder[INDEX+1:])
			
            return root
