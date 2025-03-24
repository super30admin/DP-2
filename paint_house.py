'''
Watched video again post class, to understand it more clearly
Initially the solution contains more steps, later relaized using hash_map makes code clean

SC: O(m*3)
TC: (0n*3)

Observation: The key is once you fill up the last row of the DP

You have to keep filling the each row, you will only look at the previous row every single time, as
the valus are refined from previous steps.


'''

class Solution:
    def minCost(self, costs: List[List[int]]) -> int:

        dp = [[0 for j in range(len(costs[0]))]for i in range(len(costs))]

        cols = len(costs[0])

        rows = len(costs)

        dp[rows-1][0] = costs[rows-1][0]
        dp[rows-1][1] = costs[rows-1][1]
        dp[rows-1][2] = costs[rows-1][2]
        hash_map ={}
        hash_map[0]=[1,2]
        hash_map[1] =[0,2]
        hash_map[2]=[0,1]

        for i in range(rows-2,-1,-1):
            for j in range(0, cols):
                    dp[i][j] = costs[i][j] + min(dp[i+1][hash_map[j][0]], dp[i+1][hash_map[j][1]])
        return min(dp[0])





