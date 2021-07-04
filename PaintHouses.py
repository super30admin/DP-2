"""
Time Complexity : O(m) where m is number of houses (rows in the cost matrix)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Not on leetcode
Any problem you faced while coding this: none
"""

class Solution:
    def paint(self, costs):
        length = len(costs)
        
        
        if length == 0:
            return 0
        
        for i in range(1, length):
            costs[i][0] = min(costs[i-1][1], costs[i-1][2]) + costs[i][0]
            costs[i][1] = min(costs[i-1][0], costs[i-1][2]) + costs[i][1]
            costs[i][2] = min(costs[i-1][0], costs[i-1][1]) + costs[i][2]
                
        return min(costs[-1])
    
s = Solution()
print(s.paint([[7,2,5],
               [3,6,3],
               [4,3,1]]))