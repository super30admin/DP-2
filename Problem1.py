# Paint House

#   Time Complexity : 3 * 2^(m*n)
#   Space Complexity : O(1)
#   Did this code successfully run on Leetcode : No, time limit exceeded
#   Any problem you faced while coding this : No


#  Your code here along with comments explaining your approach

# Approach 1: Recursion - Time Limit Exceeded

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        case1 = self.helper(costs, 0, 0, 0) # Blue
        case2 = self.helper(costs, 0, 1, 0) # Green
        case3 = self.helper(costs, 0, 2, 0) # Red
        
        return min(case1, min(case2, case3))
    
    
    def helper(self, costs, row, currColor, minCost):
        
        # base case
        
        if row == len(costs):
            return minCost
        
        # logic
        # For blue color
        if currColor == 0:
            return (min(self.helper(costs,row+1, 1, minCost+ costs[row][0]), 
                        self.helper(costs,row+1, 2, minCost+ costs[row][0])))
        # For green color 
        elif currColor == 1:
            return (min(self.helper(costs,row+1, 0, minCost+ costs[row][1]), 
                        self.helper(costs,row+1, 2, minCost+ costs[row][1])))
            
        # For red color 
        elif currColor == 2:
            return (min(self.helper(costs,row+1, 0, minCost+ costs[row][2]), 
                        self.helper(costs,row+1, 1, minCost+ costs[row][2])))
        
        
# Approach 2 : Dynamic Programming

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        
        if costs == None or len(costs) == 0:
            return 0
        
        i = len(costs) - 2
        while(i>=0):   
            costs[i][0] = costs[i][0] + min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0], costs[i+1][1])
            i = i-1
        
        return min(costs[0][0], min(costs[0][1], costs[0][2]))
        


        
        
        