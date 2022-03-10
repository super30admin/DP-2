#  Time Complexity : O(n*amount) where n is length of coins
#  Space Complexity : O(amount)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No
class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        amount_table = [0]*(amount + 1)
        amount_table[0] = 1
        # iterate through coins 
        for coin in coins:
            #  calulate the number for ways that coin be used to reach the amount
            for x in range(coin,amount+1):
                amount_table[x] = amount_table[x-coin] + amount_table[x]
        return amount_table[amount]