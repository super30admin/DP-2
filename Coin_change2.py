  
// Time Complexity : 2*n
// Space Complexity : O(n) n = amount+1
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach: 1st approach using 2d matrix- tabulation method using dynamic programming. 
second approach using a single dimensional array  using dp.




class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [[0 for j in range(amount+1)]for i in range(len(coins)+1)]
        
        for i in range(len(coins)+1):
            dp[i][0] = 1
            
        for i in range(1,len(coins)+1):
            for j in range(1,amount+1):
                if j < coins[i-1]:
                    dp[i][j] = dp[i-1][j]
                else:
                    dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j]
        return dp[len(coins)][amount]






class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        dp = [ 0 for _ in range(0,amount+1)]
        dp[0] =  1
        
        for i in range(1, len(coins)+1):
            for j in range(1,amount+1):
                if j >= coins[i-1]:
                    dp[j] = dp[j] + dp[j-coins[i-1]]
                    
        return dp[amount]
