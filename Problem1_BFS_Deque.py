# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = rig
from collections import deque 
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
        queue = deque([root])
        level = 0
        level_list = []
        result = []

        while queue:
            for _ in range(len(queue)):
                curr_root = queue.popleft()
                level_list.append(curr_root.val)
                print(level_list)
                if curr_root.left is not None:
                    queue.append(curr_root.left)
                if curr_root.right is not None:
                    queue.append(curr_root.right)
            result.append(level_list)
            level+=1
            level_list = []
        return result
