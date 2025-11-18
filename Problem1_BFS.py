# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]

            1
         2     3
        4 5   6 7         
        o/p: 
        [
        [1],
        [2,3],
        [4,5,6,7]
        ]
        We need to keep track of level list and rsult adds the lists
        queue takes root and next_queue adds left and right children
        Time complexity:O(N)
        Space Complexity: O(h) where h is height of tree
        """
        if root is None:
            return []
        queue = [root]
        level = []
        result = []

        while queue!=[]:
            for root in queue:
                level.append(root.val)
                if root.left is not None:
                    next_queue.append(root.left)
                if root.right is not None:
                    next_queue.append(root.right)
            result.append(level)
            level = []
            queue = next_queue
            next_queue = []
        return result
