# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Yes


# // Your code here along with comments explaining your approach
    # Iterate through each row of the matrix
    # select each element in the first row and repeat the below procedure
    # Once selected the first element in a selected row traverse all the rows below it such that the cost is min
    # once the cost is computed for all the 3 cols return the min of all the three
    
class Solution:

    def FindMinCost(costs):
        for i in range(0,len(costs)):
            costs[i][0] = costs[i][0] + min(costs[i+1][1],costs[i+1][2])
            costs[i][1] = costs[i][1] + min(costs[i+1][0],costs[i+1][2])
            costs[i][2] = costs[i][2] + min(costs[i+1][0],costs[i+1][1])
        return min(costs[i])