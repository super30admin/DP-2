'''

## Problem 518: Coin Change 2

## Author: Neha Doiphode
## Date:   07-04-2022

## Description:
    You are given an integer array coins representing coins of different denominations
    and an integer amount representing a total amount of money.
    Return the number of combinations that make up that amount.
    If that amount of money cannot be made up by any combination of the coins, return 0.
    You may assume that you have an infinite number of each kind of coin.
    The answer is guaranteed to fit into a signed 32-bit integer.

## Examples:
    Example 1:
        Input: amount = 5, coins = [1,2,5]
        Output: 4
        Explanation: there are four ways to make up the amount:
                    5=5
                    5=2+2+1
                    5=2+1+1+1
                    5=1+1+1+1+1

    Example 2:
        Input: amount = 3, coins = [2]
        Output: 0
        Explanation: the amount of 3 cannot be made up just with coins of 2.

    Example 3:
        Input: amount = 10, coins = [10]
        Output: 1

## Constraints:
    1 <= coins.length <= 300
    1 <= coins[i] <= 5000
    All the values of coins are unique.
    0 <= amount <= 5000

## Time complexity: Please refer to function doc-strings.

## Space complexity: Please refer to function doc-strings.

'''

from typing import List

def get_input():
    print("Enter the list of coin denominations with spaces: ", end = "")
    inp_list = input()
    inp_list = [int(value) for value in inp_list.split()]
    print("Enter the target amount: ", end = "")
    target_amount = int(input())
    return inp_list, target_amount

class Solution:

    def helper(self, coins: List[int], amount: int, index: int):
        # Base case
        if index == len(coins) or amount < 0:
            return 0

        if amount == 0:
            return 1

        # Do not choose case
        case_1 = self.helper(coins, amount, index + 1)

        # choose case
        case_2 = self.helper(coins, amount - coins[index], index)

        # To find the total number of possible ways
        return case_1 + case_2

    ############## TIME LIMIT EXCEEDS #######################
    def coinChange_exhaustive_search_with_recursion(self, amount: int, coins:List[int]) -> int:
        '''
        Time complexity: O(s^n), exponential time complexity as we perform exhaustive search.
        Space complexity: O(n), worst case depth of recursion will be n.
        '''
        # Check for edge cases and call the helper function
        if not len(coins):
            return 0

        index = 0
        return self.helper(coins, amount, index)

    def change(self, amount: int, coins: List[int]) -> int:
        '''
        DP table that stores number of ways to achieve certain target amount
        Y-axis = Denominations X-axis = Target amount
        Values = Number of ways to achieve the target amount with denominations available at that moment.


          |  0   1   2   3   4   5
        __|____________________________
        0 |  1   0   0   0   0   0
        1 |  1   1   1   1   1   1
        2 |  1   1   2   2   3   3
        5 |  1   1   2   2   3   4


        Time complexity: O(m * n), where m is number of denominations, n = target amount
        Space complexity: O(m * n), to store auxiliary DP array.
        '''

        # define dynamic programming array
        rows = len(coins)
        columns = amount

        # Initialize dp array
        # We are creating one extra row and column to store denomination 0 row and amount 0 column
        dp = [[0] * (columns + 1)] * (rows + 1)

        # Initialize first column with 1 as there is only 1 way we can make amount 0 with any denomination
        for row in dp:
            rows[0] = 1

        # Now that we have dp array initialized, start counting combinations with which we can achieve the target amount
        for row in range(1, rows + 1):
            for column in range(1, columns + 1):
                if column < coins[row - 1]:
                    # do not choose case, copy the value from previous denomination. Hence, same column, previous row.
                    dp[row][column] = dp[row - 1][column]
                else:
                    # choose case, hence we need to look previous denomination dp[row][column - coins[row - 1]] back and add it to the do not choose combination
                    dp[row][column] = dp[row - 1][column] + dp[row][column - coins[row - 1]]

        return dp[rows][columns]



# Driver code
solution = Solution()
coins, target_amount = get_input()
print(f"Input denominations: {coins}")
print(f"Input target amount: {target_amount}")
print(f"Approach 1: Exhaustive search with recursion: Number of possible combinations to achieve the target amount: {solution.coinChange_exhaustive_search_with_recursion(target_amount, coins)}")
print(f"Approach 2: Dynamic programming: Number of possible combinations to achieve the target amount: {solution.change(target_amount, coins)}")
