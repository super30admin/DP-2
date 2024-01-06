""" Explanation: a 2D array result to store the number of combinations for each amount and coin. It iterates through each coin and amount,
    updating result based on whether the current coin is chosen or not. The final value at result[n][amount] represents the total 
    number of combinations to make up the given amount using the provided coins.
    Time Complexcity: O(m*n)
    Space Complexcity: O(nm)
    where m is the amount and n is the number of coins
"""


class Solution(object):
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        n = len(coins)
        result = [[0] * (amount + 1) for _ in range(n + 1)]

        # Base case: There is one way to make amount 0, i.e., by not choosing any coin
        for i in range(n + 1):
            result[i][0] = 1

        for i in range(1,n+1):
            for j in range(1,amount+1):
                if(j>= coins[i-1]):
                    result[i][j] = result[i-1][j] + result[i][j-coins[i-1]]
                else:
                    result[i][j] = result[i-1][j]
        
        return result[n][amount]
        