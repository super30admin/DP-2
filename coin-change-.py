#Time Complexity :  O(amount*coins))
#Space Complexity : O(amount)
#Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        if amount == 0 or len(coins)==0:
            return 1
        else:
            dp = [0 for i in range(0,amount+1)]
            dp[0] = 1
            
            for coin in coins:
                for i in range(coin,(amount)+1):
                    if i == coin:
                        dp[i]= dp[i]+1
                    else:
                        dp[i] = dp[i] + dp[i-coin]
                        
            return dp[amount]