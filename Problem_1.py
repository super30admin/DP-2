"""
Problem : 1

Recursive
Time Complexity : O(2^(m+n))
Space Complexity : O(2^(m+n))

DP
Time Complexity : O(m*n)
Space Complexity : O(m*n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

In recursive solution - choosing or not choosing the coin and returning the addition of number of ways amount can be achieved using the given coins
In dp approach - creating a dp matrix and implementing the recursive tree in the form of table from behind
"""


# Coin change 2

# Approach - 1

class Solution(object):
    def change(self, amount, coins):
        if coins==None:
            return 0
        return self.helper(coins,0,amount)
    def helper(self,coins,idx,amount):
        # base
        if amount==0:
            return 1
        if amount<0 or idx==len(coins):
            return 0 

        # logic
        # Not choose
        case0=self.helper(coins,idx+1,amount )

        # choose
        case1=self.helper(coins,idx,amount-coins[idx]) 

        return case0+case1
    
# Approach - 2

class Solution(object):
    def change(self, amount, coins):

        dp=[[None]*(amount+1) for _ in range(len(coins)+1)]

        for i in range(amount+1):
            dp[0][i]=0
        dp[0][0]=1

        for i in range(1,len(coins)+1):
            for j in range(0,amount+1):
                if coins[i-1]>j:
                    dp[i][j]=dp[i-1][j]
                else:
                    dp[i][j]=dp[i-1][j]+dp[i][j-coins[i-1]]
        return dp[len(coins)][amount]