#Time Complexity: O(numofcoins*amount)
#Space Complexity: O(numofcoins*amount)
class Solution:
    def change(amount,coins):
        dp=[[0 for i in range(amount+1)] for j in range(len(coins)+1)] 
        for i in range(len(coins)+1):
            dp[i][0]=1
        for j in range(1,amount+1):
            dp[0][j]=0
        for coin in range(1,len(dp)):
            for amt in range(1,len(dp[0])):
                if amt<coins[coin-1]:
                    dp[coin][amt]=dp[coin-1][amt]
                else:
                    dp[coin][amt]=(dp[coin-1][amt])+(dp[coin][amt-coins[coin-1]])
        return dp[len(coins)][amount]