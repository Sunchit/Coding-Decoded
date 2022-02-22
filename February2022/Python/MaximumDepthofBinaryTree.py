# TC : O(N)
# SC : O(N)
class Solution:
    def maxDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        left = 1+self.maxDepth(root.left)
        right = 1+self.maxDepth(root.right)
        return max(left, right)
