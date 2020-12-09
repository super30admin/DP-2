class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        #O(MN)
        #O(N)
        if not coins and amount==0:
            return 1
        if not coins:
            return 0
        #dp that stores ways possible to make amount using that coin
        # base case:
        # amount 0's count = 1 (by taking no coins)
        dp = [1] + [ 0 for i in range(amount)]
    
        # make change with current coin, from small coin to large coin
        for cur_coin in coins:
            
            # update dp count from small amount to large amount
            for small_amount in range(cur_coin, amount+1):
                
                # current small amount can make changes with current coin
                dp[small_amount] += dp[small_amount - cur_coin]
                
        return dp[amount]