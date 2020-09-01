# S30 Big N Problem #22 {Medium}
# Leetcode #518

# You are given coins of different denominations and a total amount of money. 
# Write a function to compute the number of combinations that make up that amount. 
# You may assume that you have infinite number of each kind of coin.

# Time Complexity : O(n*m) n= no. of coins m=amount to be made
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No 

# Approach 
# Create a matrix of no of coins vs amount.
# Fill the first row with default values
# FOr next rows, add the no. of ways from previous coin and no of ways of current coin. 


class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        
        if amount==0:
            return 1
        if len(coins)==0:
            return 0
        
        
        
        dp=[ [0 for _ in range(amount+1)] for _ in range(len(coins)+1)]
        
        
        for i in range(len(coins)+1):
            dp[i][0]=1
            
        
        for i in range(1,len(coins)+1,1):
            for j in range(1,amount+1,1):
                
                if j<coins[i-1]:
                    dp[i][j]=dp[i-1][j]
                    
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        
        
        return dp[len(coins)][amount]
        