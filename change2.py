# Time Complexity:O(numCoins*amount)
# Space Complexity:O(numCoins*amount)
# Approach:
# if you draw tree you can see there are multiple common sub problems try greedy first and dfind test case that fails.
# For recursion solution we just do simple 01 pick not pick type time complexity will 2^m+n
# dp[coin][amount]->total ways we can achive that amount until coin from satrt of coins both by poickinga nd not picking
# dp[coin+1][am]=dp[coin][am]+dp[coin+1][am - coins[coin]]
# but if you observe we are jsut using previous row to be more precise 
# if coins[coin]>am:
#   dp[coin+1][am]=dp[coin][am]
# so can we do with 1d array than 2d? yes dp[am]=dp[am]+dp[am - coin]




class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[0 for i in range(amount+1)] 
        dp[0]=1

        for coin in coins:
            for am in range(coin,amount+1):
                
                dp[am]=dp[am]+dp[am - coin]
       

        return dp[amount]

#below is 2D dp
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        dp=[[0 for i in range(amount+1)] for _ in  range(len(coins)+1)]
        dp[0][0]=1

        for coin in range(len(coins)):
            for am in range(amount+1):
                if coins[coin]>am:
                    dp[coin+1][am]=dp[coin][am]

                else:
                    dp[coin+1][am]=dp[coin][am]+dp[coin+1][am - coins[coin]]
       

        return dp[len(coins)][amount]

        
#brute force using recursionO(2^m+n, amount),,(consider 1 as your 1st coin you pick pick untill last and then you dont pick anything and go untill end )

class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        #brute force using recursion
      

        def helper(idx,coins,amount):
            #base what are changing over here idx and amount..when should i return 1?
            if amount==0:return 1
            if idx==len(coins) or amount<0:return 0


            #logic
            #pick
            p=helper(idx,coins,amount-coins[idx])
            #not-pick
            np=helper(idx+1,coins,amount)
            return p+np
        return helper(0,coins,amount)
