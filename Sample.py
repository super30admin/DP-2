// Time Complexity :O(m * n)
// Space Complexity :O(m * n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// Coin change 2
// We calculates the number of ways by considering, for each coin, two exclusive options: excluding the current coin (case1) or including it (and potentially re-using it) to reduce the remaining amount (case2).

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        m = len(coins)
        n = amount
        self.memo = [[-1 for _ in range(n+1)]for _ in range(m+1)]
        return self.helper(coins,0,amount)

    def helper(self,coins,idx,amount):
        if amount==0: return 1
        if amount <0 or idx == len(coins): return 0
        if self.memo[idx][amount] != -1: return self.memo[idx][amount]
        case1 = self.helper(coins,idx+1,amount)
        case2 = self.helper(coins,idx,amount-coins[idx])
        self.memo[idx][amount] = case1+case2
        return case1+case2

        
// Paint House 
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : 

// first copy the last row of matrix into the dp matrix. Then the row above that gets calculated based on the below values, whatever is lower, that gets added to the current row value.
// This creates the dp matrix which has the firts row that contains the total min costs of all the combinations from the below rows. the min cost among the first row is the total min cost

class Solution:
    def minCost(self, costs: List[List[int]]) -> int: #3*2^n

        dp = [[0]*len(costs[0]) for _ in range(len(costs))]
        
        dp[-1][0] = costs[-1][0]
        dp[-1][1] = costs[-1][1]
        dp[-1][2] = costs[-1][2]
        
        for i in range(len(costs)-2,-1,-1):
            dp[i][0] = costs[i][0] + min(dp[i+1][1],dp[i+1][2])
            dp[i][1] = costs[i][1] + min(dp[i+1][0],dp[i+1][2])
            dp[i][2] = costs[i][2] + min(dp[i+1][0],dp[i+1][1])
        
        return min(dp[0])

        
        