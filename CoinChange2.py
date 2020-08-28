// Time Complexity : O(mn)
// Space Complexity : O(mn)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[[0 for i in range(amount+1)]for i in range(len(coins)+1)] # assinging dp array
        for i in range(len(coins)+1):
            dp[i][0]=1 # assinging 0 coin with 1 as as number of ways
        for i in range(1,amount+1):
            dp[0][i]=0
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]  # if total sum is greater than the coin considered, choose the dont choose option (i.e only present)
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]] #if choose and dont choose are available , go back to
                                                        # number of coins in rows in order to find the remaining coins, add both.

        return dp[len(coins)][amount] # return final answer