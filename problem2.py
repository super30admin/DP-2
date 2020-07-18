"""
Time: O(n)
Space: O(n)
Leet: Accepted
Problems faced: Struggled with breaking down
into subproblems. Once that was done it's easy.

"""

class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """

        memo = [0] * (amount + 1) #each index
        memo [0] = 1 #only one way to create the value 0
        for coin in coins:
            for i in range(1,len(memo)):
                if coin<=i:
                    memo[i] += memo[i-coin]
        return memo[-1]
