#Time complexity: O(m)   
#Space complexity: O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def minCost(self, costs):
        """
        :type costs: List[List[int]]
        :rtype: int
        """
        #Saving last row elements to use in total cost computation
        prevR,prevB,prevG= costs[-1][0],costs[-1][1],costs[-1][2]
        
        #iterating from second last row to first row
        for i in xrange(len(costs)-2,-1,-1):
            # saving values of r and b as they are bound to change
            tempR,tempB = prevR,prevB
            #at each row, calculate the min value from the two below options and add it to the cost of the item at pos
            prevR = costs[i][0]+ min(prevB,prevG)
            prevB = costs[i][1]+ min(tempR,prevG)
            prevG = costs[i][2]+ min(tempR,tempB)
        
        #minimum of all values after parsing the 2d array bottom up
        return min(prevR,prevB,prevG)
#         Dp with additional n*3 array
#         dp = [[0 for i in xrange(3)] for i in xrange(len(costs))]
        
#         for idx,el in enumerate(costs[-1]):
#             dp[-1][idx] = el
        
            
#         for i in xrange(len(dp)-2,-1,-1):
#             dp[i][0] = costs[i][0]+ min(dp[i+1][1],dp[i+1][2])
#             dp[i][1] = costs[i][1]+ min(dp[i+1][0],dp[i+1][2])
#             dp[i][2] = costs[i][2]+ min(dp[i+1][0],dp[i+1][1])
        
#         return min(dp[0][0],dp[0][1],dp[0][2])
        #recursive solution
#         def helper(costs,row,color,total):
#             #base case
#             if row==len(costs):
#                 return total
#             #logic
#             if color == 0:
#                 return min(helper(costs,row+1,1,total+costs[row][0]),helper(costs,row+1,2,total+costs[row][0]))
#             elif color == 1:
#                 return min(helper(costs,row+1,0,total+costs[row][1]),helper(costs,row+1,2,total+costs[row][1]))
#             else:
#                 return min(helper(costs,row+1,0,total+costs[row][2]),helper(costs,row+1,1,total+costs[row][2]))
            
#         caseR = helper(costs,0,0,0)
#         caseB = helper(costs,0,1,0)
#         caseG = helper(costs,0,2,0)
        
#         return min(caseR,caseB,caseG)