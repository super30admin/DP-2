# DP-2

## Problem1(https://leetcode.com/problems/paint-house/)
# Time Complexity=O(n)
# Space Complexity=O(1)
 class Solution:
    def minCost(self, costs: List[List[int]]) -> int:
        for i in range(1,len(costs)):
            costs[i][0]=costs[i][0]+min(costs[i-1][1],costs[i-1][2])
            costs[i][1]=costs[i][1]+min(costs[i-1][0],costs[i-1][2])
            costs[i][2]=costs[i][2]+min(costs[i-1][1],costs[i-1][0])
        return min(costs[len(costs)-1][1],costs[len(costs)-1][0],costs[len(costs)-1][2])
                        

## Problem2 (https://leetcode.com/problems/coin-change-2/)
# Time Complexity=O(amount*number of coins)
# Space Complexity=O(amount*number of coins)
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[[0]*(amount+1) for _ in range(len(coins)+1)]
        for i in range(len(coins)+1):
            dp[i][0]=1
        for i in range(1,amount+1):
            dp[0][i]=0
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[len(coins)][amount] 