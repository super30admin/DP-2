# // Time Complexity : O(m*n) 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : No

# dp is the array we have to store the number of combinations that will sum up to the amount from 0 to amount. 
# dp[0]=1 and rest all values are 0. for each coin, iterate through from coin to amount+1 to update teh dp value
# update the dp value to dp+dp[j-coin]. number of combinations using current coin to get current amount

class Solution(object):
    def change(self, amount, coins):
        n=amount
        dp=[0]* (n+1)
        dp[0]=1
        for coin in coins:
            for j in range(coin,n+1):
                    dp[j]=dp[j] + dp[j-coin]
        return dp[n]