# Author :  Karthik K (https://www.linkedin.com/in/karthikmunirathinam/)

class Solution:
    def getAllElements(self, root1: TreeNode, root2: TreeNode) -> List[int]:
        result = []
        self.traverse(root1, result)
        self.traverse(root2, result)
        result.sort()
        return result

    def traverse(self, root, result):
        if not root:
            return
        result.append(root.val)
        if root.left:
            self.traverse(root.left, result)
        if root.right:
            self.traverse(root.right, result)
        return
