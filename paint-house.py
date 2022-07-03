"""
Runtime Complexity:
O(n) - 'n' refers to the number of houses. The number of colors is 3 so its a constant. The runtime is O(n*3), where 3 here refers to number of colors.
But we ignore constant as per asymptotic notation. Therefore the overall runtime is O(n)
Space Complexity: O(1)  - no new data structure was created to compute the cost.
Yes, the code worked on leetcode. 
The idea behind the algorithm is we can't use exhaustive search because of the runtime limit exceed and we see repeated subproblems, so we plan to use DP.
Start from n-2 until it reaches the top. If color 0 which is red is chosen then we add that cost along with the min of other two. We do this for all the rows and return the final min cost to paint the house.
"""


class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        if len(costs)==0:
            return 0
        n = len(costs)
        
        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0] + min((costs[i+1][1]), (costs[i+1][2]))
            costs[i][1] = costs[i][1] + min((costs[i+1][0]), (costs[i+1][2]))
            costs[i][2] = costs[i][2] + min((costs[i+1][0]), (costs[i+1][1]))
        
        return min(costs[0][0], costs[0][1], costs[0][2])
            
        