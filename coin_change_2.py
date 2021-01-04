# Time Complexity : O(N * amount), where N is the length of coins array
# Space Complexity : O(amount) to keep dp array
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int      
        """
        #Base Case
        if coins == None:
            return 0
        
        #Used array to optimize it.
        dp = [0] * (amount + 1) #make a size of DP array
        dp[0] = 1 # combination of using no coins is 1 so it's 1.
        
        for coin in coins:
            for i in range(coin, amount + 1): # i start as the coin number.
                dp[i] = dp[i - coin] + dp[i] # compare the value of previous and add 1 by going step back(depends on which coin and amount)
        
        #return last amount in an array
        return dp[amount]
