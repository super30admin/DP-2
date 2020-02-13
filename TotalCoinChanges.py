class TotalCoinChanges(object):
    '''
    Solution:
    1. Problem can be solved using recursion and has overlapping subproblems and so use dynamic programming. Recursive
        step would be based on whether the coin is chosen or not.
    2. If coin is not chosen, the value of the cell would be previous row's extract, otherwise it would be sum of
        [previous row (same column) value, column minus coinValue (same row)]
    3. Return the last cell's value

    --- Passed all Leetcode testcases successfully
    '''
    def change(self, amount, coins):
        """
        :type amount: int
        :type coins: List[int]
        :rtype: int
        """
        # O(numCoins * amount) Time Complexity | O(numCoins * amount) Space Complexity
        if (coins == None): return -1
        dpCoinChange = [[0 for i in range(amount + 1)] for j in range(len(coins) + 1)]

        for rowCoin in range(len(coins) + 1):
            dpCoinChange[rowCoin][0] = 1

        for rowCoin in range(1, len(coins) + 1):
            for colAmount in range(1, amount + 1):
                if colAmount < coins[rowCoin - 1]:
                    dpCoinChange[rowCoin][colAmount] = dpCoinChange[rowCoin - 1][colAmount]
                else:
                    dpCoinChange[rowCoin][colAmount] = (dpCoinChange[rowCoin - 1][colAmount] + \
                                                        dpCoinChange[rowCoin][colAmount - coins[rowCoin - 1]])

        return dpCoinChange[len(coins)][amount]