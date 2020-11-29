# Paint House

# Time Complexity : O(Rows*Columns) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes, Runtime: 52 ms and Memory Usage: 14.1 MB
# Any problem you faced while coding this : Initally yes, After class understanding no.
# Your code here along with comments explaining your approach
# Approach
"""
Greedy Approach and recrusive approach are optimised using Dynamic Programming
with implementation of Colour and Number of house. If choosen house 1 the minimum among
two houses(2 and 3). If choosen house 2 the minimum among other two houses(1 and 3).If choosen
house 3 among other two houses (1 and 2).

"""
class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if(costs==None or len(costs)==0):
            return 0
        n=len(costs)
        for i in range(1,n):
            costs[i][0]=costs[i][0]+min(costs[i-1][1],costs[i-1][2]) 
            costs[i][1]=costs[i][1]+min(costs[i-1][0],costs[i-1][2])
            costs[i][2]=costs[i][2]+min(costs[i-1][0],costs[i-1][1])
        return min(costs[n-1][0],min(costs[n-1][1],costs[n-1][2]))