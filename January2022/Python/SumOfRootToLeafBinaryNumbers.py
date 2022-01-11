# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

# TC : O(n) where,n-->Number of nodes
# SC : O(n) Recursive stack space

class Solution:
    def sumRootToLeaf(self, root: Optional[TreeNode]) -> int:
        def dfs(node, currentVal):
            nonlocal totalSum
            if not node:
                return
            currentVal = currentVal*2+node.val
            if not node.left and not node.right:
                totalSum += currentVal
            dfs(node.left, currentVal)
            dfs(node.right, currentVal)
        totalSum = 0
        dfs(root, 0)
        return totalSum
