
"""
We have to return the min cost of painting such that no two consecutive houses should be same colored

https://leetcode.com/problems/paint-house/

Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
Minimum cost: 2 + 5 + 3 = 10.

Greedy approach : Pick min cost for all rows and if any color repeats, pich the next min

Exhaustive : We check for every house, what are the possibilities of coloring the next house and figure out the repeating problems


DP Approach : 
We start from the second-last row and for all the rows, at a particular index we check which paint to be applied to 
the house in the previous house to reduce the overall cost at that row.

In the end we return the min of the three values at the top

dp = [17, 2, 17]

TC = O(3*N) - N =  number of rows
SC = O(1)




"""

class Solution :
    def minCost (self, costs : list[list[int]]) -> int :
        n = len(costs)
        for i in range(n-2, -1, -1):
            costs[i][0] = costs[i][0]+ min(costs[i+1][1], costs[i+1][2])
            costs[i][1] = costs[i][1]+ min(costs[i+1][0], costs[i+1][2])
            costs[i][2] = costs[i][2]+ min(costs[i+1][0], costs[i+1][1])

        return min(costs[0][0], costs[0][1], costs[0][2])
costs = [[17,2,17],[16,16,5],[14,3,19]]
object = Solution()
minCost = object.minCost(costs)
print(minCost)


            



