# Time Complexity:- O(n*amount)
# Space Complexity:- O(n*amount)
# Approach:- At every point you have a choice to include a coin or not include it. If we we include the coin we increase the amount
# or we can choose to not include the coin and we will not increase the amount.
# Base Case:- if the amt becomes amount, I am starting from 0 and building up to amount we can go other way too start from amount 
# and go to zero, either ways when we reach the amount or 0 we add 1 to our solution which mean we have found a way to use coins to get to our amount. The total no of ways is by adding the results of the 2 choices.
class Solution:
    def change(self, amount, coins):
        if len(coins)==0 and amount==0:
            return 1
        @lru_cache(maxsize=None)
        def cc(i,amt):
            if amt==amount:
                return 1
            if i==len(coins) or amt>amount:
                return 0
            return cc(i,amt+coins[i])+cc(i+1,amt)
        return cc(0,0)